package com.taurus.modernandroiddevelopmentkata.movie

import com.taurus.modernandroiddevelopmentkata.core.di.scope.FragmentScope
import com.taurus.modernandroiddevelopmentkata.movie.network.MovieService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MovieModule {

  @Provides
  @FragmentScope
  fun provideMovieService(retrofit: Retrofit) = retrofit.create(MovieService::class.java)

}