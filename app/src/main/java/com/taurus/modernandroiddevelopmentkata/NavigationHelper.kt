package com.taurus.modernandroiddevelopmentkata

import android.os.Bundle
import android.widget.FrameLayout
import androidx.navigation.NavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.taurus.modernandroiddevelopmentkata.core.extensions.invisible
import com.taurus.modernandroiddevelopmentkata.core.extensions.visible
import com.taurus.modernandroiddevelopmentkata.core.navigation.TabHistory
import kotlinx.android.synthetic.main.activity_main.bottomNavigationView
import kotlinx.android.synthetic.main.activity_main.favouritesTabContainer
import kotlinx.android.synthetic.main.activity_main.movieTabContainer
import kotlinx.android.synthetic.main.activity_main.profileTabContainer
import kotlinx.android.synthetic.main.activity_main.tvSeriesTabContainer

class NavigationHelper(var tabHistory: TabHistory) {

  private var currentController: NavController? = null
  private lateinit var activity: MainActivity
  private lateinit var viewModel: MainViewModel

  private val movieTabContainer: FrameLayout by lazy { activity.movieTabContainer }
  private val tvSeriesTabContainer: FrameLayout by lazy { activity.tvSeriesTabContainer }
  private val favouritesTabContainer: FrameLayout by lazy { activity.favouritesTabContainer }
  private val profileTabContainer: FrameLayout by lazy { activity.profileTabContainer }
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

        movieTabContainer.visible()
        tvSeriesTabContainer.invisible()
        favouritesTabContainer.invisible()
        profileTabContainer.invisible()
      }
      R.id.dest_tv_series -> {
        currentController = tvSeriesNavController
        viewModel.currentNavController.postValue(tvSeriesNavController)

        tvSeriesTabContainer.visible()
        movieTabContainer.invisible()
        favouritesTabContainer.invisible()
        profileTabContainer.invisible()
      }
      R.id.dest_favourites -> {
        currentController = favouritesNavController
        viewModel.currentNavController.postValue(favouritesNavController)

        favouritesTabContainer.visible()
        tvSeriesTabContainer.invisible()
        movieTabContainer.invisible()
        profileTabContainer.invisible()
      }
      R.id.dest_profile -> {
        currentController = profileNavController
        viewModel.currentNavController.postValue(profileNavController)

        profileTabContainer.visible()
        favouritesTabContainer.invisible()
        tvSeriesTabContainer.invisible()
        movieTabContainer.invisible()
      }
    }
    if (addToHistory) {
      tabHistory.push(tabId)
    }
  }

}
