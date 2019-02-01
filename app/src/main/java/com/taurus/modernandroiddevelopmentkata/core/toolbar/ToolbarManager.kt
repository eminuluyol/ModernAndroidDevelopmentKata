package com.taurus.modernandroiddevelopmentkata.core.toolbar

import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.ui.setupWithNavController
import com.taurus.modernandroiddevelopmentkata.MainActivity


class ToolbarManager(
        private val builder: FragmentToolbar,
        private val container: View,
        private val activity: MainActivity
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
                    toolbar.setupWithNavController(activity.navController)
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
