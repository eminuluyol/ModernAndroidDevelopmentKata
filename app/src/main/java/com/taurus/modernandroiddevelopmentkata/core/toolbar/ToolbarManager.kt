package com.taurus.modernandroiddevelopmentkata.core.toolbar

import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.ui.setupWithNavController

class ToolbarManager(
    private val builder: FragmentToolbar,
    private val container: View,
    private val navController: NavController
) {

    fun prepareToolbar() {

        if (builder.resId != FragmentToolbar.NO_TOOLBAR) {
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
            }
        }
    }
}
