package com.taurus.modernandroiddevelopmentkata.core

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import com.taurus.modernandroiddevelopmentkata.MainViewModel
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.core.toolbar.ToolbarManager
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment<VM : ViewModel> : DaggerFragment() {

  interface FragmentListener {
    fun handleBottomBarVisibility(isVisible: Boolean)
  }

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory

  /**
   * ViewModel istance that provided by ViewModelProvider
   */
  protected lateinit var stateMachine: VM

  /**
   * NavController for using Navigation Arch Component
   */
  protected lateinit var navController: NavController

  private var fragmentListener: FragmentListener? = null

  abstract fun obtainViewModel(): Class<VM>

  @LayoutRes
  abstract fun layoutResId(): Int

  private lateinit var sharedViewModel: MainViewModel

  override fun onAttach(context: Context) {
    super.onAttach(context)
    try {
      this.fragmentListener = context as FragmentListener
    } catch (e: ClassCastException) {
      throw ClassCastException("$context must implement FragmentListener")
    }
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    stateMachine = ViewModelProviders.of(this, viewModelFactory).get(obtainViewModel())
    sharedViewModel = ViewModelProviders.of(requireActivity(), viewModelFactory).get(
        MainViewModel::class.java)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
      savedInstanceState: Bundle?) =
      inflater.inflate(layoutResId(), container, false)!!

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    sharedViewModel.currentNavController.observe(viewLifecycleOwner, Observer {
      it?.let { currentNavController ->
        navController = currentNavController
        ToolbarManager(toolbarBuilder(), view, requireActivity(), currentNavController).prepareToolbar()
      }
    })
    fragmentListener?.handleBottomBarVisibility(isBottomBarEnabled)
  }

  /**
   * Override and return false if you don't need the bottom bar.
   */
  protected open val isBottomBarEnabled = true


  protected abstract fun toolbarBuilder(): FragmentToolbar

}
