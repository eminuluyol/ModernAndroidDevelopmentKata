package com.taurus.modernandroiddevelopmentkata.navigation

import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.core.navigation.Navigator
import dagger.Module
import dagger.Provides

@Module
class MainNavigationModule {

    @ActivityScope
    @Provides
    fun provideNavigator(
        manager: NavigationManager
    ): Navigator = MainNavigator(manager)

}
