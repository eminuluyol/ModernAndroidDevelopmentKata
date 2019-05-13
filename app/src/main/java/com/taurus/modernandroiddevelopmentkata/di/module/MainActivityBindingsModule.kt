package com.taurus.modernandroiddevelopmentkata.di.module

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import com.taurus.modernandroiddevelopmentkata.main.MainActivity
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityBindingsModule {

    @ActivityScope
    @Binds
    abstract fun activity(mainActivity: MainActivity): Activity

    @ActivityScope
    @Binds
    abstract fun fragmentActivity(mainActivity: MainActivity): FragmentActivity
}
