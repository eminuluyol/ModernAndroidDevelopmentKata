package com.taurus.modernandroiddevelopmentkata.core.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.taurus.modernandroiddevelopmentkata.MainActivity
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.R.id
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
        tabHistory.push(id.dest_movies)
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener)

        if (savedInstanceState == null) {
            updateNavController(movieNavController, movieTabContainer)
        }
    }

    fun onBackPressed() {
        currentController?.let {
            if (it.popBackStack().not()) {
                if (tabHistory.size > 1) {
                    val tabId = tabHistory.popPrevious()
                    switchTab(tabId, false)
                    bottomNavigationView.menu.findItem(tabId)?.isChecked = true
                } else {
                    tabHistory.clear()
                    return activity.finish()
                }
            }
        } ?: run { activity.finish() }
    }

    fun switchTab(tabId: Int, addToHistory: Boolean = true) {
        when (tabId) {
            id.dest_movies -> updateNavController(movieNavController, movieTabContainer)
            id.dest_tv_series -> updateNavController(tvSeriesNavController, tvSeriesTabContainer)
            id.dest_favourites -> updateNavController(favouritesNavController, favouritesTabContainer)
            id.dest_profile -> updateNavController(profileNavController, profileTabContainer)
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
