package com.taurus.modernandroiddevelopmentkata.movie

import com.taurus.modernandroiddevelopmentkata.core.mvi.UiIntent

sealed class MovieIntent : UiIntent {

  data class MovieItemClicked(val movieId: String ) : MovieIntent()

}
