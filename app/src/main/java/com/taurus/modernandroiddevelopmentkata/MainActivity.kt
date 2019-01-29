package com.taurus.modernandroiddevelopmentkata

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.taurus.modernandroiddevelopmentkata.core.BaseActivity
import kotlinx.android.synthetic.main.activity_main.bottomNavigationView

class MainActivity : BaseActivity() {

  override fun layoutResId() = R.layout.activity_main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setupNavigation()
  }

  override fun onSupportNavigateUp() = findNavController(R.id.nav_host_fragment).navigateUp()

  private fun setupNavigation() {
    val navController = findNavController(R.id.nav_host_fragment)
    bottomNavigationView.setupWithNavController(navController)
  }

}
