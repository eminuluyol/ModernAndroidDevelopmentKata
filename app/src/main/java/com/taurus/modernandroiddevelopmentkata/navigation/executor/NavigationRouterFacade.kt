package com.taurus.modernandroiddevelopmentkata.navigation.executor

import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationRouter
import javax.inject.Inject

class NavigationRouterFacade @Inject constructor(
    private val executors: Set<@JvmSuppressWildcards NavigationExecutor>
) : NavigationRouter {

    override fun navigate(navigationCommand: NavigationCommand) {
        // TODO if (navigate().not()) continue else break
        executors.forEach { it.execute(navigationCommand) }
    }

    interface NavigationExecutor {
        fun execute(navigationCommand: NavigationCommand)
    }
}