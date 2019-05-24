package com.taurus.modernandroiddevelopmentkata.tvseries

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.core.navigation.Navigator
import com.taurus.modernandroiddevelopmentkata.tvseries.navigation.TvSeriesNavigator
import dagger.Binds
import dagger.Module

@Module
abstract class TVSeriesBindingsModule {

    @FragmentScope
    @Binds
    abstract fun provideTVSeriesNavigator(navigator: TvSeriesNavigator): Navigator

}