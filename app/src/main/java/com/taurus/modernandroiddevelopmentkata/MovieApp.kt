package com.taurus.modernandroiddevelopmentkata

import com.facebook.stetho.Stetho
import com.taurus.modernandroiddevelopmentkata.core.sharedpreference.BaseSharedPreferences
import com.taurus.modernandroiddevelopmentkata.di.component.DaggerApplicationComponent
import dagger.android.support.DaggerApplication

class MovieApp : DaggerApplication() {

    private val applicationInjector = DaggerApplicationComponent.builder()
        .application(this)
        .build()

    override fun applicationInjector() = applicationInjector

    override fun onCreate() {
        super.onCreate()
        BaseSharedPreferences.init(this)
        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)
    }
}
