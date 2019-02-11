package com.taurus.modernandroiddevelopmentkata.detail

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailModule {

    @FragmentScope
    @ContributesAndroidInjector
    internal abstract fun detailFragment(): DetailFragment
}