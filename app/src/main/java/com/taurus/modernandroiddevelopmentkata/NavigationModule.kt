package com.taurus.modernandroiddevelopmentkata

import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.TabHistory
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

  @Provides
  @ActivityScope
  fun provideTabHistory() = TabHistory()

  @Provides
  @ActivityScope
  fun provideNavigationHelper(tabHistory: TabHistory) = NavigationHelper(tabHistory)

}