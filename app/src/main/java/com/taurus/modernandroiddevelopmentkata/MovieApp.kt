package com.taurus.modernandroiddevelopmentkata

import com.taurus.modernandroiddevelopmentkata.core.di.component.DaggerApplicationComponent
import dagger.android.DaggerApplication

class MovieApp : DaggerApplication() {

  private val applicationInjector = DaggerApplicationComponent.builder()
      .application(this)
      .build()

  override fun applicationInjector() = applicationInjector
}