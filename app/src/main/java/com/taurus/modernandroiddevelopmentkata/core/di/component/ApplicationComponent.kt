package com.taurus.modernandroiddevelopmentkata.core.di.component

import com.taurus.modernandroiddevelopmentkata.MovieApp
import com.taurus.modernandroiddevelopmentkata.core.di.module.ApplicationModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent : AndroidInjector<MovieApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: MovieApp): Builder

        fun build(): ApplicationComponent
    }
}
