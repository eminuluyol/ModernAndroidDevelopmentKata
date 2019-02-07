package com.taurus.modernandroiddevelopmentkata.navigation

import androidx.annotation.IdRes
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand

data class TabNavigationCommand(@IdRes val tabId: Int) : NavigationCommand