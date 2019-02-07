package com.taurus.modernandroiddevelopmentkata.navigation

import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationRouter
import com.taurus.modernandroiddevelopmentkata.navigation.router.AppNavigationRouter
import com.taurus.modernandroiddevelopmentkata.navigation.router.MoviesNavigationRouter
import com.taurus.modernandroiddevelopmentkata.navigation.router.NavigationRouterFacade
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet

@Module
class NavigationModule {

    @Provides
    @ActivityScope
    @ElementsIntoSet
    fun provideRouters(
        appNavigationRouter: AppNavigationRouter,
        moviesNavigationRouter: MoviesNavigationRouter
    ): Set<NavigationRouterFacade.NavigationExecutor> =
        setOf(appNavigationRouter, moviesNavigationRouter)

    @Provides
    @ActivityScope
    fun provideNavigationRouter(navigationRouterFacade: NavigationRouterFacade): NavigationRouter =
    // TODO provide something proper here
        object : NavigationRouter {
            override fun navigate(navigationCommand: NavigationCommand) {
                navigationRouterFacade.process(navigationCommand)
            }
        }
}
