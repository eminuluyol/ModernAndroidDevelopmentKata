package com.taurus.modernandroiddevelopmentkata.navigation

import android.app.Activity
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class NavigationManager @Inject constructor(
    private val activity: Activity,
    private val tabContainer: TabContainer
) {

    lateinit var tabHistory: TabHistory
        private set

    private val currentController: NavController?
        get() = tabContainer.getNavController(tabHistory.currentTabId)

    fun bind(tabHistory: TabHistory) {
        this.tabHistory = tabHistory
        switchTab(tabHistory.currentTabId, false)
    }

    fun switchTab(tabId: Int) {
        switchTab(tabId, true)
    }

    private fun switchTab(tabId: Int, addToHistory: Boolean = true) {
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

    fun navigateUp(): Boolean = currentController?.navigateUp() ?: false

    interface TabContainer {
        fun bind()
        fun showTab(@IdRes tabId: Int)
        fun getNavController(tabId: Int): NavController
    }
}