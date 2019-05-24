package com.taurus.modernandroiddevelopmentkata.tvseries

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TVSeriesBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [TVSeriesBindingsModule::class])
    abstract fun tvSeriesFragment(): TVSeriesFragment
}
