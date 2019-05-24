package com.taurus.modernandroiddevelopmentkata.tvseries.navigation

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.tvseries.TVSeriesFragmentDirections
import javax.inject.Inject

@FragmentScope
internal class TvSeriesNavigator @Inject constructor(
    private val navigationManager: NavigationManager
) {

    fun navigate(navigationCommand: NavigationCommand) {
        val navDirections = when (navigationCommand) {
            is FromTvSeriesToDetails -> TVSeriesFragmentDirections.navigateToDetails(navigationCommand.movieId)
            else -> null
        }
        navDirections?.let { navigationManager.navigate(it) }
    }
}
