package com.taurus.modernandroiddevelopmentkata.core.di.module

import com.taurus.modernandroiddevelopmentkata.MainActivity
import com.taurus.modernandroiddevelopmentkata.core.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {

  @ActivityScope
  @ContributesAndroidInjector(modules = [(FragmentBuilderModule::class)])
  abstract fun mainActivity(): MainActivity

}
