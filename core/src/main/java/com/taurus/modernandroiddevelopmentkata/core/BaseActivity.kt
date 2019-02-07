package com.taurus.modernandroiddevelopmentkata.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.taurus.modernandroiddevelopmentkata.core.di.viewmodel.ViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity<VM : ViewModel> : DaggerAppCompatActivity() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelFactory<VM>

    /**
     * ViewModel instance that provided by ViewModelProvider
     */

    protected lateinit var viewModel: VM
        private set

    abstract fun obtainViewModel(): Class<VM>

    @LayoutRes
    abstract fun layoutResId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(layoutResId())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(obtainViewModel())
    }

}
