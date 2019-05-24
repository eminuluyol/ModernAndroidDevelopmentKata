package com.taurus.modernandroiddevelopmentkata.di.module

import com.taurus.modernandroiddevelopmentkata.detail.DetailBuilderModule
import com.taurus.modernandroiddevelopmentkata.favourites.FavouriteBuilderModule
import com.taurus.modernandroiddevelopmentkata.movies.MovieBuilderModule
import com.taurus.modernandroiddevelopmentkata.profile.ProfileBuilderModule
import com.taurus.modernandroiddevelopmentkata.similarmovies.SimilarMoviesModule
import com.taurus.modernandroiddevelopmentkata.tvseries.TVSeriesBuilderModule
import dagger.Module

@Module(includes = [
    MovieBuilderModule::class,
    TVSeriesBuilderModule::class,
    FavouriteBuilderModule::class,
    ProfileBuilderModule::class,
    DetailBuilderModule::class,
    SimilarMoviesModule::class
])
abstract class FragmentBuilderModule