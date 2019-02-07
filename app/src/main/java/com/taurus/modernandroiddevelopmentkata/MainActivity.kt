package com.taurus.modernandroiddevelopmentkata

import android.content.Intent
import android.os.Bundle
import com.taurus.modernandroiddevelopmentkata.core.BaseActivity
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.extensions.visibility
import com.taurus.modernandroiddevelopmentkata.navigation.NavigationHelper
import com.taurus.modernandroiddevelopmentkata.navigation.NavigationViewModel
import kotlinx.android.synthetic.main.activity_main.bottomNavigationView
import javax.inject.Inject

class MainActivity : BaseActivity<NavigationViewModel>(), BaseFragment.FragmentListener {

    override fun obtainViewModel() = NavigationViewModel::class.java

    @Inject
    lateinit var navigationHelper: NavigationHelper

    override fun layoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigationHelper.bind(this, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        navigationHelper.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        navigationHelper.onRestoreInstanceState(savedInstanceState)
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        navigationHelper.supportNavigateUpTo(upIntent)
    }

    override fun onBackPressed() {
        navigationHelper.onBackPressed()
    }

    override fun handleBottomBarVisibility(isVisible: Boolean) {
        bottomNavigationView.visibility(isVisible)
    }
}
