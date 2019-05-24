package com.taurus.modernandroiddevelopmentkata.favourites

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FavouriteBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun favouriteFragment(): FavouriteFragment
}
