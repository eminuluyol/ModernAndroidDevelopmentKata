package com.taurus.modernandroiddevelopmentkata

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.taurus.modernandroiddevelopmentkata.core.extensions.invisible
import com.taurus.modernandroiddevelopmentkata.core.extensions.visible
import com.taurus.modernandroiddevelopmentkata.core.navigation.TabHistory
import kotlinx.android.synthetic.main.activity_main.bottomNavigationView
import kotlinx.android.synthetic.main.activity_main.favouritesTab
import kotlinx.android.synthetic.main.activity_main.movieTab
import kotlinx.android.synthetic.main.activity_main.profileTab
import kotlinx.android.synthetic.main.activity_main.tvSeriesTab

class NavigationHelper(var tabHistory: TabHistory) {

  private var currentController: NavController? = null
  private lateinit var activity: MainActivity
  private lateinit var viewModel: MainViewModel

  private val movieTabContainer: Fragment by lazy { activity.movieTab }
  private val tvSeriesTabContainer: Fragment by lazy { activity.tvSeriesTab }
  private val favouritesTabContainer: Fragment by lazy { activity.favouritesTab }
  private val profileTabContainer: Fragment by lazy { activity.profileTab }
  private val bottomNavigationView: BottomNavigationView by lazy { activity.bottomNavigationView }

  private lateinit var movieNavController: NavController
  private lateinit var tvSeriesNavController: NavController
  private lateinit var favouritesNavController: NavController
  private lateinit var profileNavController: NavController

  private val navigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
    switchTab(item.itemId)
    return@OnNavigationItemSelectedListener true
  }

  fun bind(
      activity: MainActivity,
      viewModel: MainViewModel,
      savedInstanceState: Bundle?,
      movieNavController: NavController,
      tvSeriesNavController: NavController,
      favouritesNavController: NavController,
      profileNavController: NavController
  ) {
    this.activity = activity
    this.viewModel = viewModel
    this.movieNavController = movieNavController
    this.tvSeriesNavController = tvSeriesNavController
    this.favouritesNavController = favouritesNavController
    this.profileNavController = profileNavController
    setupNavigation(savedInstanceState)
  }

  private fun setupNavigation(savedInstanceState: Bundle?) {
    tabHistory.push(R.id.dest_movies)
    bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener)

    if (savedInstanceState == null) {
      currentController = movieNavController
      viewModel.currentNavController.postValue(movieNavController)
      movieTabContainer.view?.visible()
      tvSeriesTabContainer.view?.invisible()
      favouritesTabContainer.view?.invisible()
      profileTabContainer.view?.invisible()
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
      R.id.dest_movies -> {
        currentController = movieNavController
        viewModel.currentNavController.postValue(movieNavController)

        movieTabContainer.view?.visible()
        tvSeriesTabContainer.view?.invisible()
        favouritesTabContainer.view?.invisible()
        profileTabContainer.view?.invisible()
      }
      R.id.dest_tv_series -> {
        currentController = tvSeriesNavController
        viewModel.currentNavController.postValue(tvSeriesNavController)

        tvSeriesTabContainer.view?.visible()
        movieTabContainer.view?.invisible()
        favouritesTabContainer.view?.invisible()
        profileTabContainer.view?.invisible()
      }
      R.id.dest_favourites -> {
        currentController = favouritesNavController
        viewModel.currentNavController.postValue(favouritesNavController)

        favouritesTabContainer.view?.visible()
        tvSeriesTabContainer.view?.invisible()
        movieTabContainer.view?.invisible()
        profileTabContainer.view?.invisible()
      }
      R.id.dest_profile -> {
        currentController = profileNavController
        viewModel.currentNavController.postValue(profileNavController)

        profileTabContainer.view?.visible()
        favouritesTabContainer.view?.invisible()
        tvSeriesTabContainer.view?.invisible()
        movieTabContainer.view?.invisible()
      }
    }
    if (addToHistory) {
      tabHistory.push(tabId)
    }
  }

}
