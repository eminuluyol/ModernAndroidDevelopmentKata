package com.taurus.modernandroiddevelopmentkata.navigation

import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import dagger.Module
import dagger.Provides

@Module
class MainNavigationModule {

    @Provides
    @ActivityScope
    fun provideNavigator(
        manager: NavigationManager
    ) = MainNavigator(manager)

}
