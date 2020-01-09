package com.taurus.modernandroiddevelopmentkata.movies.navigation

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.movies.MovieFragmentDirections
import javax.inject.Inject

@FragmentScope
internal class MovieNavigator @Inject constructor(
    private val navigationManager: NavigationManager
) {

    fun navigate(navigationCommand: NavigationCommand) {
        val navDirections = when (navigationCommand) {
            is FromMoviesToDetails -> MovieFragmentDirections.navigateToDetails(navigationCommand.movieId)
            else -> null
        }
        navDirections?.let { navigationManager.navigate(it) }
    }
}
