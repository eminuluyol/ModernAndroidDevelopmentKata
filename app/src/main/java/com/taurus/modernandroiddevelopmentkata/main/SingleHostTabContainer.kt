package com.taurus.modernandroiddevelopmentkata.main

import android.widget.FrameLayout
import androidx.annotation.IdRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.navigation.NavigationManager
import kotlinx.android.synthetic.main.activity_main_single_container.*
import javax.inject.Inject

@ActivityScope
class SingleHostTabContainer @Inject constructor(
    private val activity: FragmentActivity,
    private val bottomNavigationViewHolder: BottomNavigationViewHolder
) : NavigationManager.TabContainer {

    // this relies on the layout from activity_main_single_container.xml
    private val tabContainer: FrameLayout by lazy { activity.tabContentContainer }

    override fun getNavController(tabId: Int): NavController =
        tabContainer.findNavController() //.children.map { it.findNavController() }.first()

    override fun showTab(tabId: Int) {
        val tag = tabId.toString()
        var fragment = activity.supportFragmentManager.findFragmentByTag(tag)
        if (fragment == null) {
            fragment = NavHostFragment()
            fragment.findNavController().initWithStartDestination(tabId)
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.tabContentContainer, fragment, tag)
            .commit()

        bottomNavigationViewHolder.highlightTabItem(tabId)
    }

    private fun NavController.initWithStartDestination(@IdRes destId: Int) = apply {
        graph = navInflater.inflate(R.navigation.navigation_graph).apply {
            startDestination = destId
        }
    }
}
