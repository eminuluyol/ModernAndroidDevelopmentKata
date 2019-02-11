package com.taurus.modernandroiddevelopmentkata.navigation.executor

import com.taurus.modernandroiddevelopmentkata.NavigationGraphDirections
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.detail.navigation.NavigateFromDetailsToSimilarMovies
import com.taurus.modernandroiddevelopmentkata.navigation.NavigationManager
import javax.inject.Inject

class DetailsNavigationExecutor @Inject constructor(
    private val navigationManager: NavigationManager
) : NavigationRouterFacade.NavigationExecutor {

    override fun execute(navigationCommand: NavigationCommand) {
        val navDirections = when (navigationCommand) {
            is NavigateFromDetailsToSimilarMovies -> NavigationGraphDirections.navigationGraphSimilarMoviesStart(navigationCommand.movieId)
            else -> null
        }
        navDirections?.let { navigationManager.navigate(it) }
    }
}