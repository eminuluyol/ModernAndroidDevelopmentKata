package com.taurus.modernandroiddevelopmentkata.core.extensions

import android.graphics.Color
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.view.WindowManager.LayoutParams
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.taurus.modernandroiddevelopmentkata.R.color


fun Fragment.setTransparentStatusBar() {
  if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
    this.requireActivity().apply {
      window.addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
      window.addFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS)
      window.statusBarColor = Color.TRANSPARENT
    }
  }
}

fun Fragment.clearTransparentStatusBarFlag() {
  if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
    this.requireActivity().apply {
      window.clearFlags(LayoutParams.FLAG_TRANSLUCENT_STATUS)
      window.addFlags(LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
      window.statusBarColor = ContextCompat.getColor(this, color.colorPrimaryDark)
    }
  }
}