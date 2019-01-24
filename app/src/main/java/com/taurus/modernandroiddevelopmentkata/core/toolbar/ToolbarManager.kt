package com.taurus.modernandroiddevelopmentkata.core.toolbar

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.FragmentActivity


class ToolbarManager constructor(
    private var builder: FragmentToolbar,
    private var container: View,
    private var activity: FragmentActivity
) {

  fun prepareToolbar() {

    if (builder.resId != FragmentToolbar.NO_TOOLBAR) {
      val containerActivity = activity as AppCompatActivity
      val fragmentToolbar: Toolbar? = container.findViewById(builder.resId)

      fragmentToolbar?.let {
        containerActivity.setSupportActionBar(fragmentToolbar)

        if (builder.title != FragmentToolbar.NO_TITLE) {
          fragmentToolbar.setTitle(builder.title)
        }

        if (builder.noTitle != FragmentToolbar.TITLE_ENABLED) {
          containerActivity.supportActionBar!!.setDisplayShowTitleEnabled(false)
        }

        if (builder.isOnHomePressedDefaultAction) {
          containerActivity.setSupportActionBar(fragmentToolbar)
          containerActivity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        if (builder.customHomeAsUpIndicator != FragmentToolbar.NO_CUSTOM_HOME_AS_UP_INDICATOR) {
          containerActivity.setSupportActionBar(fragmentToolbar)
          containerActivity.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
          containerActivity.supportActionBar!!.setHomeAsUpIndicator(builder.customHomeAsUpIndicator)
        }

        if (builder.isTransparentStatusBar) {
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            containerActivity.apply {
              window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
              window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
              window.statusBarColor = Color.TRANSPARENT
            }
          }
        }

      }
    }
  }

}
