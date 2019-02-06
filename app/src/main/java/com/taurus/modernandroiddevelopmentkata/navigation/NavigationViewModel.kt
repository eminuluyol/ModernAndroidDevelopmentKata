package com.taurus.modernandroiddevelopmentkata.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NavigationViewModel : ViewModel() {

    private val _navigationRouter = MutableLiveData<NavigationEvent<String>>()

    val navigationRouter: LiveData<NavigationEvent<String>>
        get() = _navigationRouter

    fun updateNavigationEvent(itemId: String) {
        _navigationRouter.value = NavigationEvent(itemId)  // Trigger the event by setting a new Event as a new value
    }

}
