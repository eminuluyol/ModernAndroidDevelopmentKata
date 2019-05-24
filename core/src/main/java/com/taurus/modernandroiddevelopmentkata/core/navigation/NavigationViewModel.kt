package com.taurus.modernandroiddevelopmentkata.core.navigation

import androidx.lifecycle.ViewModel
import com.taurus.modernandroiddevelopmentkata.core.R
import javax.inject.Inject

class NavigationViewModel @Inject constructor() : ViewModel() {

    val tabHistory: TabHistory = TabHistory(R.id.navigation_movies)
}
