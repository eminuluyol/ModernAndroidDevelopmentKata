package com.taurus.modernandroiddevelopmentkata.movies.navigation

import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.Navigator
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.movies.MovieFragmentDirections
import javax.inject.Inject

class MovieNavigator @Inject constructor(
    private val navigationManager: NavigationManager
) : Navigator {

    override fun navigate(navigationCommand: NavigationCommand) {
        val navDirections = when (navigationCommand) {
            is FromMoviesToDetails -> MovieFragmentDirections.navigateToDetails(navigationCommand.movieId)
            else -> null
        }
        navDirections?.let { navigationManager.navigate(it) }
    }
}