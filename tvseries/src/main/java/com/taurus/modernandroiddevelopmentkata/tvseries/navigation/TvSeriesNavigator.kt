package com.taurus.modernandroiddevelopmentkata.tvseries.navigation

import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.core.navigation.Navigator
import com.taurus.modernandroiddevelopmentkata.tvseries.TVSeriesFragmentDirections
import javax.inject.Inject

class TvSeriesNavigator @Inject constructor(
    private val navigationManager: NavigationManager
) : Navigator {

    override fun navigate(navigationCommand: NavigationCommand) {
        val navDirections = when (navigationCommand) {
            is FromTvSeriesToDetails -> TVSeriesFragmentDirections.navigateToDetails(navigationCommand.movieId)
            else -> null
        }
        navDirections?.let { navigationManager.navigate(it) }
    }
}
