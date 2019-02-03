package com.taurus.modernandroiddevelopmentkata.core.mvi

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
abstract class StateMachine<I : UiIntent, VS : ViewState>(
    initialState: VS
) : ViewModel(), CoroutineScope {

  override val coroutineContext: CoroutineContext = Job() + Dispatchers.IO

  private var _state = initialState
  val state get() = _state
  val stateAsDefault get() = state

  private val _intents = Channel<I>(Channel.CONFLATED)
  val intents: SendChannel<I> get() = _intents

  private val useCases = Channel<ReceiveChannel<UseCaseUpdate>>(Channel.UNLIMITED)

  /*
   * Normally a ConflatedBroadcastChannel would be used for state changes, but since the renderer
   * needs to receive each and every state in order to update the view according to the state
   * type, an ArrayBroadcastChannel must be used instead.
   */
  @ExperimentalCoroutinesApi
  private val _states = BroadcastChannel<VS>(1)

  @ExperimentalCoroutinesApi
  private val states: ReceiveChannel<VS>
    get() = _states.openSubscription().also { _states.offer(stateAsDefault) }

  init {
    launch {
      _intents.consumeEach {
        useCases.send(handleIntent(it))
      }
    }
    launch {
      useCases.consumeEach { updates ->
        launch {
          updates.consumeEach {
            _state = updateState(it)
            _states.send(_state)
          }
        }
      }
    }

    launch {
      states.consumeEach {
        onViewStateChanged(it)
      }
    }
  }

  protected abstract fun handleIntent(intent: I): ReceiveChannel<UseCaseUpdate>

  protected abstract fun updateState(update: UseCaseUpdate): VS

  protected abstract fun onViewStateChanged(lastViewState : VS)

  override fun onCleared() {
    super.onCleared()
    coroutineContext.cancel()
  }
}
