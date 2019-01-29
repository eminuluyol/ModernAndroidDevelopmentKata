package com.taurus.modernandroiddevelopmentkata.core.toolbar

import androidx.annotation.IdRes
import androidx.annotation.StringRes

@DslMarker
annotation class ToolbarDSL

class FragmentToolbar constructor(
    @IdRes val resId: Int,
    @StringRes val title: Int,
    val isOnHomePressedDefaultAction: Boolean,
    val isTransparentStatusBar: Boolean
) {

  companion object {
    const val NO_TOOLBAR = -1
    const val NO_TITLE = -1

    fun decorateToolbar(@IdRes resId: Int,
        func: FragmentToolbar.Builder.() -> Unit): FragmentToolbar {
      return Builder()
          .withId(resId)
          .apply(func)
          .build()
    }
  }

  @ToolbarDSL
  class Builder {
    private var resId: Int = NO_TOOLBAR
    private var title: Int = -1
    private var noTitle = false
    private var isOnHomePressedDefaultAction = false
    private var isTransparentStatusBar = false

    @ToolbarDSL
    fun withId(@IdRes resId: Int) = apply { this.resId = resId }

    @ToolbarDSL
    fun withTitle(title: Int) = apply { this.title = title }

    @ToolbarDSL
    fun noToolbar() = apply { this.resId = NO_TOOLBAR }

    @ToolbarDSL
    fun onHomePressedDefaultAction() = apply {
      this.isOnHomePressedDefaultAction = true
    }

    @ToolbarDSL
    fun withTransparentStatusBar() = apply { this.isTransparentStatusBar = true }

    fun build(): FragmentToolbar = FragmentToolbar(
        resId,
        title,
        isOnHomePressedDefaultAction,
        isTransparentStatusBar
    )
  }
}