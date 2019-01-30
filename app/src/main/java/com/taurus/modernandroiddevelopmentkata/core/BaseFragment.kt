package com.taurus.modernandroiddevelopmentkata.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.core.toolbar.ToolbarManager
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel> : DaggerFragment() {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  protected lateinit var stateMachine: VM

  protected lateinit var navController: NavController

  abstract fun obtainViewModel(): Class<VM>

  @LayoutRes
  abstract fun layoutResId(): Int

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    stateMachine = ViewModelProviders.of(this, viewModelFactory).get(obtainViewModel())
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?) = inflater.inflate(layoutResId(), container, false)!!

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    navController = Navigation.findNavController(view)
    ToolbarManager(toolbarBuilder(), view, requireActivity(), navController).prepareToolbar()
  }

  protected abstract fun toolbarBuilder(): FragmentToolbar

}