package com.taurus.modernandroiddevelopmentkata.navigation.executor

import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.movies.MovieFragmentDirections
import com.taurus.modernandroiddevelopmentkata.movies.navigation.NavigateFromMoviesToDetails
import com.taurus.modernandroiddevelopmentkata.navigation.NavigationManager
import javax.inject.Inject

class MoviesNavigationExecutor @Inject constructor(
    private val navigationManager: NavigationManager
) : NavigationRouterFacade.NavigationExecutor {

    override fun execute(navigationCommand: NavigationCommand) {
        val navDirections = when (navigationCommand) {
            is NavigateFromMoviesToDetails -> MovieFragmentDirections.navigationGraphDetailsStart(navigationCommand.movieId)
            else -> null
        }
        navDirections?.let { navigationManager.navigate(it) }
    }
}