package com.taurus.modernandroiddevelopmentkata.tvseries

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.core.navigation.Navigator
import com.taurus.modernandroiddevelopmentkata.tvseries.navigation.TvSeriesNavigator
import dagger.Module
import dagger.Provides

@Module
class TVSeriesModule {

    @FragmentScope
    @Provides
    internal fun provideNavigator(manager: NavigationManager) = TvSeriesNavigator(manager)

}
