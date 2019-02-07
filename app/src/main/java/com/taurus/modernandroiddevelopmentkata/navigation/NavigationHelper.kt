package com.taurus.modernandroiddevelopmentkata.navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.taurus.modernandroiddevelopmentkata.MainActivity
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.extensions.hideAllExcept
import kotlinx.android.synthetic.main.activity_main.bottomNavigationView
import kotlinx.android.synthetic.main.activity_main.favouritesTab
import kotlinx.android.synthetic.main.activity_main.movieTab
import kotlinx.android.synthetic.main.activity_main.profileTab
import kotlinx.android.synthetic.main.activity_main.tvSeriesTab

class NavigationHelper(private var tabHistory: TabHistory) {

    private val startDestinations = mapOf(
        R.id.navigation_movies to R.id.movie_fragment,
        R.id.navigation_tv_series to R.id.tv_series_fragment,
        R.id.navigation_favourites to R.id.favourites_fragment,
        R.id.navigation_profile to R.id.profile_fragment
    )

    private var currentTabId: Int = R.id.navigation_movies
    private var currentController: NavController? = null
    private lateinit var activity: MainActivity

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

    private val movieTabContainer: Fragment by lazy { activity.movieTab }
    private val tvSeriesTabContainer: Fragment by lazy { activity.tvSeriesTab }
    private val favouritesTabContainer: Fragment by lazy { activity.favouritesTab }
    private val profileTabContainer: Fragment by lazy { activity.profileTab }
    private val bottomNavigationView: BottomNavigationView by lazy { activity.bottomNavigationView }

    private val views by lazy {
        listOf(
            movieTabContainer,
            tvSeriesTabContainer,
            favouritesTabContainer,
            profileTabContainer
        )
    }

    private val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        switchTab(item.itemId)
        return@OnNavigationItemSelectedListener true
    }

    fun bind(activity: MainActivity, savedInstanceState: Bundle?) {
        this.activity = activity
        setupNavigation(savedInstanceState)
    }

    private fun setupNavigation(savedInstanceState: Bundle?) {
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener)

        if (savedInstanceState == null) {
            updateNavController(movieNavController, movieTabContainer)
        }
    }

    fun supportNavigateUpTo(upIntent: Intent) {
        currentController?.navigateUp()
    }

    fun onBackPressed() {
        currentController?.let {
            if (it.currentDestination?.id == startDestinations.getValue(currentTabId)) {
                tabHistory.popPrevious()?.let { tabId ->
                    switchTab(tabId, false)
                    bottomNavigationView.menu.findItem(tabId)?.isChecked = true
                } ?: activity.finish()
            } else {
                it.popBackStack()
            }
        } ?: activity.finish()
    }

    fun switchTab(tabId: Int, addToHistory: Boolean = true) {
        currentTabId = tabId
        when (tabId) {
            R.id.navigation_movies -> updateNavController(movieNavController, movieTabContainer)
            R.id.navigation_tv_series -> updateNavController(tvSeriesNavController,
                tvSeriesTabContainer)
            R.id.navigation_favourites -> updateNavController(favouritesNavController,
                favouritesTabContainer)
            R.id.navigation_profile -> updateNavController(profileNavController,
                profileTabContainer)
        }
        if (addToHistory) {
            tabHistory.push(tabId)
        }
    }

    private fun updateNavController(navController: NavController, tabContainer: Fragment) {
        currentController = navController
        views.hideAllExcept(tabContainer)
    }

    fun onSaveInstanceState(outState: Bundle?) {
        outState?.putSerializable(TAB_HISTORY, tabHistory)
    }

    fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        savedInstanceState?.let {
            tabHistory = it.getSerializable(TAB_HISTORY) as TabHistory
            switchTab(bottomNavigationView.selectedItemId, false)
        }
    }

    private companion object {
        const val TAB_HISTORY = "tab_history"
    }

}
