package com.taurus.modernandroiddevelopmentkata.navigation.router

import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import javax.inject.Inject

class NavigationRouterFacade @Inject constructor(
    private val routers: Set<@JvmSuppressWildcards NavigationExecutor>
) {

    fun process(navigationCommand: NavigationCommand) {
        // TODO if (navigate().not()) continue else break
        routers.forEach { it.execute(navigationCommand) }
    }

    interface NavigationExecutor {
        fun execute(navigationCommand: NavigationCommand)
    }
}