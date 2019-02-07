package com.taurus.modernandroiddevelopmentkata.navigation

import android.app.Activity
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class NavigationManager @Inject constructor(
    private val activity: Activity,
    private val tabContainer: TabContainer
) {

    lateinit var tabHistory: TabHistory
        private set

    private val currentTabId: Int
        get() = tabHistory.peek()
    private var currentController: NavController? = null

    private val startDestinations = mapOf(
        R.id.navigation_movies to R.id.navigation_movies,
        R.id.navigation_tv_series to R.id.navigation_tv_series,
        R.id.navigation_favourites to R.id.navigation_favourites,
        R.id.navigation_profile to R.id.navigation_profile
    )

    private val movieNavController: NavController by lazy {
        activity.findNavController(R.id.movieTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_graph).apply {
                startDestination = startDestinations.getValue(R.id.navigation_movies)
            }
        }
    }
    private val tvSeriesNavController: NavController by lazy {
        activity.findNavController(R.id.tvSeriesTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_graph).apply {
                startDestination = startDestinations.getValue(R.id.navigation_tv_series)
            }
        }
    }
    private val favouritesNavController: NavController by lazy {
        activity.findNavController(R.id.favouritesTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_graph).apply {
                startDestination = startDestinations.getValue(R.id.navigation_favourites)
            }
        }
    }
    private val profileNavController: NavController by lazy {
        activity.findNavController(R.id.profileTab).apply {
            graph = navInflater.inflate(R.navigation.navigation_graph).apply {
                startDestination = startDestinations.getValue(R.id.navigation_profile)
            }
        }
    }

    fun bind(tabHistory: TabHistory) {
        this.tabHistory = tabHistory
        switchTab(tabHistory.peek(), false)
    }

    fun switchTab(tabId: Int) {
        switchTab(tabId, true)
    }

    private fun switchTab(tabId: Int, addToHistory: Boolean = true) {
        currentController = when (tabId) {
            R.id.navigation_movies -> movieNavController
            R.id.navigation_tv_series -> tvSeriesNavController
            R.id.navigation_favourites -> favouritesNavController
            R.id.navigation_profile -> profileNavController
            else -> throw IllegalArgumentException("Unexpected tab id")
        }
        if (addToHistory) {
            tabHistory.push(tabId)
        }
        tabContainer.showTab(tabId)
    }

    fun onBackPressed() {
        currentController?.let {
            if (it.currentDestination?.id == startDestinations.getValue(currentTabId)) {
                tabHistory.popPrevious()?.let { tabId ->
                    switchTab(tabId, false)
                } ?: activity.finish()
            } else {
                it.popBackStack()
            }
        } ?: activity.finish()
    }

    fun navigate(navDirections: NavDirections) {
        currentController?.navigate(navDirections)
    }

    fun supportNavigateUp() {
        currentController?.navigateUp()
    }

    interface TabContainer {
        fun showTab(@IdRes tabId: Int)
    }

}