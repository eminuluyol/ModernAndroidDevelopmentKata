package com.taurus.modernandroiddevelopmentkata.core.toolbar

import android.graphics.Color
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.view.View
import android.view.WindowManager.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController
import com.taurus.modernandroiddevelopmentkata.R.color


class ToolbarManager(
    private val builder: FragmentToolbar,
    private val container: View,
    private val activity: FragmentActivity,
    private val navController: NavController
) {

  fun prepareToolbar() {

    if (builder.resId != FragmentToolbar.NO_TOOLBAR) {
      val containerActivity = activity as AppCompatActivity
      val fragmentToolbar: Toolbar? = container.findViewById(builder.resId)

      fragmentToolbar?.let { toolbar ->

        if (builder.title != FragmentToolbar.NO_TITLE) {
          toolbar.setTitle(builder.title)
        }

        if (builder.stringTitle.isNotEmpty()) {
          toolbar.title = builder.stringTitle
        }

        if (builder.isOnHomePressedDefaultAction) {
          toolbar.setupWithNavController(navController)
        }

        if (builder.isTransparentStatusBar) {
          setTransparentStatusBar(containerActivity)
        } else {
          clearTransparentStatusBarFlag(containerActivity)
        }

      }
    }
  }

  private fun setTransparentStatusBar(containerActivity: AppCompatActivity) {
    if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
      containerActivity.apply {
        window.addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.addFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = Color.TRANSPARENT
      }
    }
  }

  private fun clearTransparentStatusBarFlag(containerActivity: AppCompatActivity) {
    if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
      containerActivity.apply {
        window.clearFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, color.colorPrimaryDark)
      }
    }
  }

}
