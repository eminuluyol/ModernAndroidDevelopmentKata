package com.taurus.modernandroiddevelopmentkata.movie

import com.taurus.modernandroiddevelopmentkata.core.mvi.ViewState

sealed class MovieViewState(
    open val movieList: List<Movie> = emptyList(),
    open val isLoading: Boolean = false,
    open val errorMessage: String = ""
) : ViewState {

  object InitialState : MovieViewState(isLoading = true)

}
