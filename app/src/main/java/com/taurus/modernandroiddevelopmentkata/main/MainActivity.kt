package com.taurus.modernandroiddevelopmentkata.main

import android.content.Intent
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseActivity
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationViewModel
import kotlinx.android.synthetic.main.activity_main_single_container.*
import javax.inject.Inject

class MainActivity : BaseActivity<NavigationViewModel>(
    R.layout.activity_main_single_container,
    NavigationViewModel::class.java
), BaseFragment.FragmentListener {

    @Inject
    lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        } // Else, need to wait for onRestoreInstanceState

        handleDeeplinkIntent(intent)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setupBottomNavigationBar()
    }

    /**
     * Called on first creation and when restoring state.
     */
    private fun setupBottomNavigationBar() {

        val navGraphIds = listOf(
            R.navigation.navigation_movies,
            R.navigation.navigation_tv_series,
            R.navigation.navigation_favourites,
            R.navigation.navigation_profile
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(this, Observer { navController ->
            navigationManager.update(navController)
        })

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleDeeplinkIntent(intent)
    }

    private fun handleDeeplinkIntent(intent: Intent?) {
        // uncomment to simulate custom deep link handling
        // navigationRouter.navigate(TabNavigationCommand(R.id.navigation_tv_series))
        // navigationRouter.navigate(NavigateFromTvSeriesToDetails("from deep link"))
        // navigationRouter.navigate(NavigateFromDetailsToSimilarMovies("from deep link"))
    }

    override fun onSupportNavigateUp(): Boolean {
        return navigationManager.navigateUp()
    }

    override fun handleBottomBarVisibility(isVisible: Boolean) {
        bottomNavigationView.isVisible = isVisible
    }
}
