package com.taurus.modernandroiddevelopmentkata.core.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/**
 * The class is a factory that provides you with as many instances of a [VM] as you need.
 *
 * 1. Inject [ViewModelFactory] of your type:
 *
 *      @Inject
 *      internal lateinit var vmInjectionFactory: VmInjectionFactory<MyViewModel>
 *
 * 2. Scope your [ViewModelProvider] to a fragment/activity and use [ViewModelProvider.get] (key, class) with no fear.
 *
 *      ViewModelProviders.of(fragment, vmInjectionFactory).get(key, class)
 *
 */
class ViewModelFactory<VM : ViewModel> @Inject constructor(
    private val viewModelProvider: Provider<VM>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(clazz: Class<T>): T = viewModelProvider.get() as T
}
