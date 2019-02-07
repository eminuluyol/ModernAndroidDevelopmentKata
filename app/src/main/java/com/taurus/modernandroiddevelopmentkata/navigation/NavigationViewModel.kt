package com.taurus.modernandroiddevelopmentkata.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.taurus.modernandroiddevelopmentkata.core.navigation.Event
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationRouter

class NavigationViewModel : ViewModel(), NavigationRouter {

    private val _navigationRouter = MutableLiveData<Event<NavigationCommand>>()

    val navigationRouter: LiveData<Event<NavigationCommand>>
        get() = _navigationRouter

    override fun navigate(navigationCommand: NavigationCommand) {
        _navigationRouter.postValue(Event(navigationCommand))
    }
}
