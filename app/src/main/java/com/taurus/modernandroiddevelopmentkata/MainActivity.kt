package com.taurus.modernandroiddevelopmentkata

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.taurus.modernandroiddevelopmentkata.core.BaseActivity
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.extensions.visibility
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), BaseFragment.FragmentListener {

    val navController by lazy(LazyThreadSafetyMode.NONE) { findNavController(R.id.nav_host_fragment) }

    override fun layoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        bottomNavigationView.setupWithNavController(navController)
    }

    override fun handleBottomBarVisibility(isVisible: Boolean) {
        bottomNavigationView.visibility(isVisible)
    }

    override fun onSupportNavigateUp(): Boolean = navController.navigateUp()
}
