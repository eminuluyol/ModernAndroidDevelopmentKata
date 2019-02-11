package com.taurus.modernandroiddevelopmentkata.di.module

import com.taurus.modernandroiddevelopmentkata.MainActivity
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.navigation.executor.NavigationExecutorModule
import com.taurus.modernandroiddevelopmentkata.similarmovies.SimilarMoviesModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainActivityBindingsModule::class,
        FragmentBuilderModule::class,
        NavigationExecutorModule::class
    ])
    abstract fun mainActivity(): MainActivity

}
