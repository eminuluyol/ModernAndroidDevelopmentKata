package com.taurus.modernandroiddevelopmentkata.core.navigation

import androidx.navigation.NavController
import androidx.navigation.NavDirections
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
class NavigationManager @Inject constructor() {

    private var currentNavController: NavController? = null

    fun update(controller: NavController) {
        currentNavController = controller
    }

    fun navigate(navDirections: NavDirections) {
        currentNavController?.navigate(navDirections)
    }

    fun navigateUp(): Boolean = currentNavController?.navigateUp() ?: false
}
