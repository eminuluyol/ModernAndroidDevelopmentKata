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

    private var currentController: NavController? = null

    private val movieNavController: NavController by lazy {
        activity.findNavController(R.id.movieTab).initWithStartDestination(R.id.navigation_movies)
    }
    private val tvSeriesNavController: NavController by lazy {
        activity.findNavController(R.id.tvSeriesTab).initWithStartDestination(R.id.navigation_tv_series)
    }
    private val favouritesNavController: NavController by lazy {
        activity.findNavController(R.id.favouritesTab).initWithStartDestination(R.id.navigation_favourites)
    }
    private val profileNavController: NavController by lazy {
        activity.findNavController(R.id.profileTab).initWithStartDestination(R.id.navigation_profile)
    }

    private fun NavController.initWithStartDestination(@IdRes destId: Int) = apply {
        graph = navInflater.inflate(R.navigation.navigation_graph).apply {
            startDestination = destId
        }
    }

    fun bind(tabHistory: TabHistory) {
        this.tabHistory = tabHistory
        switchTab(tabHistory.currentTabId, false)
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
            if (it.currentDestination?.id == tabHistory.currentTabId) {
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