package com.taurus.modernandroiddevelopmentkata.core.navigation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.taurus.modernandroiddevelopmentkata.MainActivity
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.extensions.hideAllExcept
import kotlinx.android.synthetic.main.activity_main.*

class NavigationHelper(var tabHistory: TabHistory) {

    private var currentController: NavController? = null
    private lateinit var activity: MainActivity

    private val movieNavController: NavController by lazy {
        activity.findNavController(R.id.movieTab)
    }
    private val tvSeriesNavController: NavController by lazy {
        activity.findNavController(R.id.tvSeriesTab)
    }
    private val favouritesNavController: NavController by lazy {
        activity.findNavController(R.id.favouritesTab)
    }
    private val profileNavController: NavController by lazy {
        activity.findNavController(R.id.profileTab)
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
            if (it.currentDestination?.id == it.graph.startDestination) {
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
        when (tabId) {
            R.id.dest_movies -> updateNavController(movieNavController, movieTabContainer)
            R.id.dest_tv_series -> updateNavController(tvSeriesNavController, tvSeriesTabContainer)
            R.id.dest_favourites -> updateNavController(favouritesNavController, favouritesTabContainer)
            R.id.dest_profile -> updateNavController(profileNavController, profileTabContainer)
        }
        if (addToHistory) {
            tabHistory.push(tabId)
        }
    }

    private fun updateNavController(navController: NavController, tabContainer: Fragment) {
        currentController = navController
        views.hideAllExcept(tabContainer)
    }

}
