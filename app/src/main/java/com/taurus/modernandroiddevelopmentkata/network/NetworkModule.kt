package com.taurus.modernandroiddevelopmentkata.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.taurus.modernandroiddevelopmentkata.BuildConfig
import com.taurus.modernandroiddevelopmentkata.core.utilities.debug
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val okHttpBuilder = OkHttpClient.Builder()
        debug { okHttpBuilder.addInterceptor(loggingInterceptor) }
        okHttpBuilder.addInterceptor(RequestInterceptor())
        return okHttpBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(CoroutineCallAdapterFactory.invoke())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BuildConfig.API_URL)
            .build()

}
