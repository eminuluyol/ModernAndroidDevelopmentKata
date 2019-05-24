package com.taurus.modernandroiddevelopmentkata.detail

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.Navigator
import com.taurus.modernandroiddevelopmentkata.detail.navigation.DetailsNavigator
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class DetailBindingsModule {

    @FragmentScope
    @Binds
    abstract fun provideDetailNavigator(navigator: DetailsNavigator): Navigator
}