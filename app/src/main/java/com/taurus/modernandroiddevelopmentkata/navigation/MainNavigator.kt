package com.taurus.modernandroiddevelopmentkata.navigation

import com.taurus.modernandroiddevelopmentkata.core.navigation.BackCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.Navigator
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.core.navigation.TabNavigationCommand
import javax.inject.Inject

class MainNavigator @Inject constructor(
    private val navigationManager: NavigationManager
) : Navigator {

    override fun navigate(navigationCommand: NavigationCommand) {
        when (navigationCommand) {
            is BackCommand -> navigationManager.onBackPressed()
            is TabNavigationCommand -> navigationManager.switchTab(navigationCommand.tabId)
        }
    }
}