package com.taurus.modernandroiddevelopmentkata.movies

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.movies.navigation.MovieNavigator
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @FragmentScope
    @Provides
    internal fun provideNavigator(manager: NavigationManager) = MovieNavigator(manager)
}
