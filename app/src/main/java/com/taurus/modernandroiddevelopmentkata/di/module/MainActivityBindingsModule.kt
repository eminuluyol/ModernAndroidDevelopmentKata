package com.taurus.modernandroiddevelopmentkata.di.module

import android.app.Activity
import com.taurus.modernandroiddevelopmentkata.MainActivity
import com.taurus.modernandroiddevelopmentkata.MainActivityViewContainer
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.navigation.NavigationManager
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityBindingsModule {

    @ActivityScope
    @Binds
    abstract fun activity(mainActivity: MainActivity): Activity

    @ActivityScope
    @Binds
    abstract fun tabContainer(mainActivityViewContainer: MainActivityViewContainer):
        NavigationManager.TabContainer
}
