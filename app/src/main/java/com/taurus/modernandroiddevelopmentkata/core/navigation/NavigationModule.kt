package com.taurus.modernandroiddevelopmentkata.core.navigation

import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

  @Provides
  @ActivityScope
  fun provideTabHistory() = TabHistory()

  @Provides
  @ActivityScope
  fun provideNavigationHelper(tabHistory: TabHistory) = NavigationHelper(
      tabHistory)

}