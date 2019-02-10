package com.taurus.modernandroiddevelopmentkata.navigation.executor

import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.tvseries.TVSeriesFragmentDirections
import com.taurus.modernandroiddevelopmentkata.tvseries.navigation.NavigateFromTvSeriesToDetails
import javax.inject.Inject

class TvSeriesNavigationExecutor @Inject constructor(
    private val navigationManager: NavigationManager
) : NavigationRouterFacade.NavigationExecutor {

    override fun execute(navigationCommand: NavigationCommand) {
        val navDirections = when (navigationCommand) {
            is NavigateFromTvSeriesToDetails -> TVSeriesFragmentDirections.navigateFromTvSeriesToDetails(navigationCommand.movieId)
            else -> null
        }
        navDirections?.let { navigationManager.navigate(it) }
    }
}
