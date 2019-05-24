package com.taurus.modernandroiddevelopmentkata.di.module

import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.main.MainActivity
import com.taurus.modernandroiddevelopmentkata.navigation.MainNavigationModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainActivityBindingsModule::class,
        MainActivityProvidesModule::class,
        FragmentBuilderModule::class,
        MainNavigationModule::class
    ])
    abstract fun mainActivity(): MainActivity

}
