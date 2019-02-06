package com.taurus.modernandroiddevelopmentkata.navigation

import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    @Provides
    @ActivityScope
    fun provideTabHistory() = TabHistory(R.id.dest_movies)

    @Provides
    @ActivityScope
    fun provideNavigationHelper(tabHistory: TabHistory) = NavigationHelper(tabHistory)

}
