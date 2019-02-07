package com.taurus.modernandroiddevelopmentkata.navigation.router

import com.taurus.modernandroiddevelopmentkata.core.navigation.BackCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.navigation.TabNavigationCommand
import javax.inject.Inject

class AppNavigationRouter @Inject constructor(
    private val navigationManager: NavigationManager
) : NavigationRouterFacade.NavigationExecutor {

    override fun execute(navigationCommand: NavigationCommand) {
        when (navigationCommand) {
            is BackCommand -> navigationManager.onBackPressed()
            is TabNavigationCommand -> navigationManager.switchTab(navigationCommand.tabId)
        }
    }
}