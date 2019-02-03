package com.taurus.modernandroiddevelopmentkata.movie.network

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

  @GET("movie/popular")
  fun popularMovies() : Deferred<Response<MovieRemoteData>>

}
