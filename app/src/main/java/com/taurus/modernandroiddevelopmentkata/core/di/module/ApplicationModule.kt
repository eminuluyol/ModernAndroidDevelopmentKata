package com.taurus.modernandroiddevelopmentkata.core.di.module

import android.content.Context
import com.taurus.modernandroiddevelopmentkata.MovieApp
import com.taurus.modernandroiddevelopmentkata.core.utilities.ResourceHelper
import com.taurus.modernandroiddevelopmentkata.network.NetworkModule
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class,
        NetworkModule::class
    ]
)
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(movieApp: MovieApp): Context = movieApp.applicationContext

    @Provides
    @Singleton
    fun provideResourceHelper(context: Context) = ResourceHelper(context)

}
