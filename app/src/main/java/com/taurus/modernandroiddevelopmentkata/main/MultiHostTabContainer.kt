package com.taurus.modernandroiddevelopmentkata.main

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.core.extensions.hideAllExcept
import com.taurus.modernandroiddevelopmentkata.navigation.NavigationManager
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@ActivityScope
class MultiHostTabContainer @Inject constructor(
    activity: FragmentActivity,
    private val bottomNavigationViewHolder: BottomNavigationViewHolder
) : NavigationManager.TabContainer {

    // this relies on the layout from activity_main.xml
    private val movieTabContainer: Fragment by lazy { activity.movieTab }
    private val tvSeriesTabContainer: Fragment by lazy { activity.tvSeriesTab }
    private val favouritesTabContainer: Fragment by lazy { activity.favouritesTab }
    private val profileTabContainer: Fragment by lazy { activity.profileTab }

    private val views by lazy {
        listOf(
            movieTabContainer,
            tvSeriesTabContainer,
            favouritesTabContainer,
            profileTabContainer
        )
    }

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

    override fun getNavController(tabId: Int): NavController {
        return when (tabId) {
            R.id.navigation_movies -> movieNavController
            R.id.navigation_tv_series -> tvSeriesNavController
            R.id.navigation_favourites -> favouritesNavController
            R.id.navigation_profile -> profileNavController
            else -> throw IllegalArgumentException("Unexpected tab id")
        }
    }

    override fun showTab(tabId: Int) {
        val tabContainer = when (tabId) {
            R.id.navigation_movies -> movieTabContainer
            R.id.navigation_tv_series -> tvSeriesTabContainer
            R.id.navigation_favourites -> favouritesTabContainer
            R.id.navigation_profile -> profileTabContainer
            else -> throw IllegalArgumentException("Unexpected tab id")
        }
        views.hideAllExcept(tabContainer)
        bottomNavigationViewHolder.highlightTabItem(tabId)
    }
}
