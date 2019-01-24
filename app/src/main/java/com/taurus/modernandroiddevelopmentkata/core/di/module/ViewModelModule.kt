package com.taurus.modernandroiddevelopmentkata.core.di.module

import androidx.lifecycle.ViewModelProvider
import com.taurus.modernandroiddevelopmentkata.core.di.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelModule {

  @Binds
  abstract fun provideViewModelFactory(
      viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}