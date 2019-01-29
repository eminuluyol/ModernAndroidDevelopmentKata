package com.taurus.modernandroiddevelopmentkata.core.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.taurus.modernandroiddevelopmentkata.core.di.key.ViewModelKey
import com.taurus.modernandroiddevelopmentkata.core.di.viewmodel.ViewModelFactory
import com.taurus.modernandroiddevelopmentkata.movie.DetailStateMachine
import com.taurus.modernandroiddevelopmentkata.movie.FavouriteStateMachine
import com.taurus.modernandroiddevelopmentkata.movie.MovieStateMachine
import com.taurus.modernandroiddevelopmentkata.movie.ProfileStateMachine
import com.taurus.modernandroiddevelopmentkata.movie.TVSeriesStateMachine
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal abstract class ViewModelModule {

  @Binds
  abstract fun provideViewModelFactory(
      viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

  @Binds
  @IntoMap
  @ViewModelKey(MovieStateMachine::class)
  internal abstract fun movieStateMachine(stateMachine: MovieStateMachine): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(TVSeriesStateMachine::class)
  internal abstract fun tvSeriesStateMachine(stateMachine: TVSeriesStateMachine): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(FavouriteStateMachine::class)
  internal abstract fun favouriteStateMachine(stateMachine: FavouriteStateMachine): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(ProfileStateMachine::class)
  internal abstract fun profileStateMachine(stateMachine: ProfileStateMachine): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(DetailStateMachine::class)
  internal abstract fun detailStateMachine(stateMachine: DetailStateMachine): ViewModel

}