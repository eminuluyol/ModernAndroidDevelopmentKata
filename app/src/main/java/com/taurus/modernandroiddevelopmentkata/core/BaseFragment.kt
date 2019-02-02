package com.taurus.modernandroiddevelopmentkata.core

import android.content.Context
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

    interface FragmentListener {
        fun handleBottomBarVisibility(isVisible: Boolean)
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    /**
     * ViewModel istance that provided by ViewModelProvider
     */
    private lateinit var stateMachine: VM

    /**
     * NavController for using Navigation Arch Component
     */
    private lateinit var navController: NavController

    private var fragmentListener: FragmentListener? = null

    abstract fun obtainViewModel(): Class<VM>

    @LayoutRes
    abstract fun layoutResId(): Int

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
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) =
            inflater.inflate(layoutResId(), container, false)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        ToolbarManager(toolbarBuilder(), view, requireActivity(), navController).prepareToolbar()
        fragmentListener?.handleBottomBarVisibility(isBottomBarEnabled)
        onReadyToRender(view, stateMachine, navController)
    }

    /**
     * Override and return false if you don't need the bottom bar.
     */
    protected open val isBottomBarEnabled = true

    protected abstract fun toolbarBuilder(): FragmentToolbar

    protected abstract fun onReadyToRender(view: View, stateMachine: VM, navController: NavController)

}
