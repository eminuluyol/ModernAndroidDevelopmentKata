package com.taurus.modernandroiddevelopmentkata.core.di.module

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import com.taurus.modernandroiddevelopmentkata.detail.DetailFragment
import com.taurus.modernandroiddevelopmentkata.detail.DetailModule
import com.taurus.modernandroiddevelopmentkata.favourite.FavouriteFragment
import com.taurus.modernandroiddevelopmentkata.favourite.FavouriteModule
import com.taurus.modernandroiddevelopmentkata.movie.MovieFragment
import com.taurus.modernandroiddevelopmentkata.movie.MovieModule
import com.taurus.modernandroiddevelopmentkata.profile.ProfileFragment
import com.taurus.modernandroiddevelopmentkata.profile.ProfileModule
import com.taurus.modernandroiddevelopmentkata.tvseries.TVSeriesFragment
import com.taurus.modernandroiddevelopmentkata.tvseries.TVSeriesModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [MovieModule::class])
    abstract fun movieFragment(): MovieFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [TVSeriesModule::class])
    abstract fun tvSeriesFragment(): TVSeriesFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [FavouriteModule::class])
    abstract fun favouriteFragment(): FavouriteFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ProfileModule::class])
    abstract fun profileFragment(): ProfileFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun detailFragment(): DetailFragment

}
