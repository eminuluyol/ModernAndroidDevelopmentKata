package com.taurus.modernandroiddevelopmentkata.core.toolbar

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes

@DslMarker
annotation class ToolbarDSL

class FragmentToolbar constructor(
    @IdRes val resId: Int,
    @StringRes val title: Int,
    val noTitle: Boolean,
    val isOnHomePressedDefaultAction: Boolean,
    @DrawableRes val customHomeAsUpIndicator: Int
) {

  companion object {
    const val NO_TOOLBAR = -1
    const val NO_CUSTOM_HOME_AS_UP_INDICATOR = -1
    const val NO_TITLE = -1
    const val TITLE_ENABLED = false

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
    private var customHomeAsUpIndicator = -1

    @ToolbarDSL
    fun withId(@IdRes resId: Int) = apply { this.resId = resId }

    @ToolbarDSL
    fun withTitle(title: Int) = apply { this.title = title }

    @ToolbarDSL
    fun noToolbar() = apply { this.resId = NO_TOOLBAR }

    @ToolbarDSL
    fun withNoTitle() = apply { this.noTitle = true }

    @ToolbarDSL
    fun onHomePressedDefaultAction() = apply {
      this.isOnHomePressedDefaultAction = true
    }

    @ToolbarDSL
    fun withCustomHomeAsUpIndicator(@DrawableRes drawableRes: Int) = apply {
      this.customHomeAsUpIndicator = drawableRes
      this.isOnHomePressedDefaultAction = false
    }

    fun build(): FragmentToolbar = FragmentToolbar(
        resId,
        title,
        noTitle,
        isOnHomePressedDefaultAction,
        customHomeAsUpIndicator
    )
  }
}