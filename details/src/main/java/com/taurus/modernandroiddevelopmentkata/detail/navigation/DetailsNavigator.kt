package com.taurus.modernandroiddevelopmentkata.detail.navigation

import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.core.navigation.Navigator
import com.taurus.modernandroiddevelopmentkata.detail.DetailFragmentDirections
import javax.inject.Inject

class DetailsNavigator @Inject constructor(
    private val navigationManager: NavigationManager
) : Navigator {

    override fun navigate(navigationCommand: NavigationCommand) {
        val navDirections = when (navigationCommand) {
            is FromDetailsToSimilarMovies -> DetailFragmentDirections.navigateToSimilarMovies(navigationCommand.movieId)
            else -> null
        }
        navDirections?.let { navigationManager.navigate(it) }
    }
}