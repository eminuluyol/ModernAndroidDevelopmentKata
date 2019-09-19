package com.taurus.modernandroiddevelopmentkata.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.taurus.modernandroiddevelopmentkata.core.di.viewmodel.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VM : ViewModel>(
    @LayoutRes private val layoutResId: Int,
    private val viewModelClass: Class<VM>
) : DaggerAppCompatActivity() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory<VM>

    protected lateinit var viewModel: VM
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)
    }
}
