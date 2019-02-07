package com.taurus.modernandroiddevelopmentkata.navigation

import androidx.lifecycle.ViewModel
import com.taurus.modernandroiddevelopmentkata.R
import javax.inject.Inject

class NavigationViewModel @Inject constructor() : ViewModel() {

    val tabHistory: TabHistory = TabHistory(R.id.navigation_movies)
}
