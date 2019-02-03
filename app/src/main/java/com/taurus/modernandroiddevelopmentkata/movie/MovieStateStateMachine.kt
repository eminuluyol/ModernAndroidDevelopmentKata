package com.taurus.modernandroiddevelopmentkata.movie

import com.taurus.modernandroiddevelopmentkata.core.mvi.StateMachine
import com.taurus.modernandroiddevelopmentkata.core.mvi.UseCaseUpdate
import com.taurus.modernandroiddevelopmentkata.movie.usecase.FetchPopularMoviesUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
class MovieStateStateMachine(
    private val fetchPopularMoviesUseCase: FetchPopularMoviesUseCase
) : StateMachine<MovieIntent, MovieViewState>(MovieViewState.InitialState) {

  override fun handleIntent(intent: MovieIntent) = when (intent) {
  }

  override fun updateState(update: UseCaseUpdate): MovieViewState {
  }

  override fun onViewStateChanged(lastViewState: MovieViewState) {

  }

}