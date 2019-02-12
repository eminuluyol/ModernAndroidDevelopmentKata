package com.taurus.modernandroiddevelopmentkata.di.module

import com.taurus.modernandroiddevelopmentkata.main.MainActivity
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.navigation.executor.NavigationExecutorModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainActivityBindingsModule::class,
        MainActivityProvidesModule::class,
        FragmentBuilderModule::class,
        NavigationExecutorModule::class
    ])
    abstract fun mainActivity(): MainActivity

}
