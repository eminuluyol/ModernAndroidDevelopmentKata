package com.taurus.modernandroiddevelopmentkata.movie.network

import com.taurus.modernandroiddevelopmentkata.movie.MovieItem

object MovieUiDataTransformer {

  fun transform(remoteDataList: List<Result>) =
      remoteDataList.map {
        create(it)
      }.toMutableList()

  private fun create(item: Result) = MovieItem(
      backdropPath = item.backdropPath,
      id = item.id,
      posterPath = item.posterPath,
      title = item.title,
      voteAverage = item.voteAverage
  )
}