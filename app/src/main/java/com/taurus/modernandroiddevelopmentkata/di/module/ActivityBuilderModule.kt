package com.taurus.modernandroiddevelopmentkata.di.module

import com.taurus.modernandroiddevelopmentkata.MainActivity
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.navigation.NavigationModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [(FragmentBuilderModule::class), NavigationModule::class])
    abstract fun mainActivity(): MainActivity

}
