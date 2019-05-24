package com.taurus.modernandroiddevelopmentkata.profile

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ProfileBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun profileFragment(): ProfileFragment
}
