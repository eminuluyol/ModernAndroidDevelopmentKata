package com.taurus.modernandroiddevelopmentkata

import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.core.extensions.hideAllExcept
import com.taurus.modernandroiddevelopmentkata.navigation.NavigationManager
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@ActivityScope
class MainActivityViewContainer @Inject constructor(
    activity: MainActivity
) : NavigationManager.TabContainer {

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

    fun bind(onTabClick: (Int) -> Unit) {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            onTabClick(it.itemId)
            true
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
        bottomNavigationView.menu.findItem(tabId)?.isChecked = true
    }
}
