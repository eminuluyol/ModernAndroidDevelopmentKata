package com.taurus.modernandroiddevelopmentkata.main

import android.app.Activity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import kotlinx.android.synthetic.main.activity_main.bottomNavigationView
import javax.inject.Inject

@ActivityScope
class BottomNavigationViewHolder @Inject constructor(activity: Activity) {

    private val bottomNavigationView: BottomNavigationView by lazy { activity.bottomNavigationView }

    fun bind(onTabClick: (Int) -> Unit) {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            onTabClick(it.itemId)
            true
        }
    }

    fun highlightTabItem(tabId: Int) {
        bottomNavigationView.menu.findItem(tabId)?.isChecked = true
    }
}
