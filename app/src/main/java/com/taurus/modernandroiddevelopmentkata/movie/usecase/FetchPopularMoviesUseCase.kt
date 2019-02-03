package com.taurus.modernandroiddevelopmentkata.movie.usecase

import com.taurus.modernandroiddevelopmentkata.core.mvi.UseCaseUpdate
import com.taurus.modernandroiddevelopmentkata.core.utilities.Result
import com.taurus.modernandroiddevelopmentkata.core.utilities.safeApiCall
import com.taurus.modernandroiddevelopmentkata.movie.MovieItem
import com.taurus.modernandroiddevelopmentkata.movie.network.MovieService
import com.taurus.modernandroiddevelopmentkata.movie.network.MovieUiDataTransformer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.produce
import java.io.IOException
import javax.inject.Inject

class FetchPopularMoviesUseCase @Inject constructor(
    private val movieService: MovieService
) {

  sealed class Update : UseCaseUpdate {
    data class Success(val searchResults: List<MovieItem>) : Update()
    data class Failure(val errorMessage: Exception) : Update()
  }

  @ExperimentalCoroutinesApi
  operator fun invoke() = GlobalScope.produce {
    val result = getMovies()
    when (result) {
      is Result.Success -> send(Update.Success(result.data))
      is Result.Error -> send(Update.Failure(result.exception))
    }
  }

  private suspend fun getMovies() = safeApiCall(
      call = { popularMovies() },
      errorMessage = "Error occurred"
  )

  private suspend fun popularMovies(): Result<List<MovieItem>> {
    val response = movieService.popularMovies().await()
    return if (response.isSuccessful) {
      val uiData = MovieUiDataTransformer.transform(response.body()!!.results)
      Result.Success(uiData)
    } else {
      Result.Error(IOException("Error occurred during fetching movies!"))
    }
  }

}
