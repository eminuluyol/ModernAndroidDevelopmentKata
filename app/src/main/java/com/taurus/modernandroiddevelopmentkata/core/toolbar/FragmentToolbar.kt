package com.taurus.modernandroiddevelopmentkata.core.toolbar

import androidx.annotation.IdRes
import androidx.annotation.StringRes

@DslMarker
annotation class ToolbarDSL

class FragmentToolbar private constructor(
    @IdRes val resId: Int,
    @StringRes val title: Int,
    val stringTitle: String,
    val isOnHomePressedDefaultAction: Boolean
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
        private var isOnHomePressedDefaultAction = false
        private var stringTitle = ""

        fun withId(@IdRes resId: Int) = apply { this.resId = resId }

        fun withTitle(stringTitle: String) = apply { this.stringTitle = stringTitle }

        fun withTitle(title: Int) = apply { this.title = title }

        fun noToolbar() = apply { this.resId = NO_TOOLBAR }

        fun onHomePressedDefaultAction() = apply {
            this.isOnHomePressedDefaultAction = true
        }

        fun build(): FragmentToolbar = FragmentToolbar(
            resId,
            title,
            stringTitle,
            isOnHomePressedDefaultAction
        )
    }
}
