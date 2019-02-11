package com.taurus.modernandroiddevelopmentkata.similarmovies

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SimilarMoviesModule {

    @FragmentScope
    @ContributesAndroidInjector//(modules = [SimilarMoviesDepsModule::class])
    abstract fun similarMoviesFragment(): SimilarMoviesFragment
}