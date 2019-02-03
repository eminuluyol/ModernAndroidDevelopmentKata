package com.taurus.modernandroiddevelopmentkata.movie

import android.view.View
import androidx.navigation.NavController
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import kotlinx.android.synthetic.main.fragment_movie.showDetailButton

class MovieFragment : BaseFragment<MovieStateStateMachine>() {

  override fun obtainViewModel() = MovieStateStateMachine::class.java

  override fun layoutResId() = R.layout.fragment_movie

  override fun toolbarBuilder(): FragmentToolbar {
    return FragmentToolbar.decorateToolbar(R.id.toolbar) {
      withTitle(R.string.movies)
    }
  }

  override fun onReadyToRender(
      view: View,
      stateMachine: MovieStateStateMachine,
      navController: NavController
  ) {
    showDetailButton.setOnClickListener {
      navController.navigate(
          MovieFragmentDirections.destMoviesToDestDetails("From Movie Fragment")
      )
    }
  }

}
