package com.taurus.modernandroiddevelopmentkata

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.taurus.modernandroiddevelopmentkata.core.BaseActivity
import kotlinx.android.synthetic.main.activity_main.bottomNavigationView

class MainActivity : BaseActivity() {

  override fun layoutResId() = R.layout.activity_main

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setupNavigation()
  }

  override fun onSupportNavigateUp() = Navigation.findNavController(this,
      R.id.nav_host_fragment).navigateUp()

  private fun setupNavigation() {
    val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
    NavigationUI.setupWithNavController(bottomNavigationView, navController)
  }

}
