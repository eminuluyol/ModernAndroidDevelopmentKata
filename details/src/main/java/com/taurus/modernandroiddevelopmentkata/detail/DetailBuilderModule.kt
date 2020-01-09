package com.taurus.modernandroiddevelopmentkata.detail

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class DetailBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [DetailBindingsModule::class])
    internal abstract fun detailFragment(): DetailFragment

}