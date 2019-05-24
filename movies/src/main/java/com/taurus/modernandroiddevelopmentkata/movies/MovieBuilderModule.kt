package com.taurus.modernandroiddevelopmentkata.movies

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MovieBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [MovieBindingsModule::class])
    abstract fun movieFragment(): MovieFragment
}
