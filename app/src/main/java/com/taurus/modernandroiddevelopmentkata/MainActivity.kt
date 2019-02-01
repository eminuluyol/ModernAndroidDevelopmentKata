package com.taurus.modernandroiddevelopmentkata

import android.os.Bundle
import com.taurus.modernandroiddevelopmentkata.core.BaseActivity
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.extensions.visibility
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BaseFragment.FragmentListener {

    override fun layoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun handleBottomBarVisibility(isVisible: Boolean) {
        bottomNavigationView.visibility(isVisible)
    }

}
