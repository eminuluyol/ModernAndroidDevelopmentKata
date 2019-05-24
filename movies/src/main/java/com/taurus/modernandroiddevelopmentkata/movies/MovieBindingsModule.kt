package com.taurus.modernandroiddevelopmentkata.movies

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.core.navigation.Navigator
import com.taurus.modernandroiddevelopmentkata.movies.navigation.MovieNavigator
import dagger.Binds
import dagger.Module

@Module
abstract class MovieBindingsModule {

    @FragmentScope
    @Binds
    abstract fun provideMovieNavigator(navigator: MovieNavigator): Navigator
}