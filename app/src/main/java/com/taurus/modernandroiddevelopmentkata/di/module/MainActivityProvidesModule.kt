package com.taurus.modernandroiddevelopmentkata.di.module

import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.main.MultiHostTabContainer
import com.taurus.modernandroiddevelopmentkata.main.SingleHostTabContainer
import dagger.Module
import dagger.Provides

@Module
class MainActivityProvidesModule {

    @ActivityScope
    @Provides
    fun tabContainer(multiHostTabContainer: MultiHostTabContainer,
        singleHostTabContainer: SingleHostTabContainer):
        NavigationManager.TabContainer =  singleHostTabContainer

}
