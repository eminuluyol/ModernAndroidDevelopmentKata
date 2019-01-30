package com.taurus.modernandroiddevelopmentkata.movie

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import kotlinx.android.synthetic.main.fragment_movie.showDetailButton

class MovieFragment : BaseFragment<MovieStateMachine>() {

  override fun obtainViewModel() = MovieStateMachine::class.java

  override fun layoutResId() = R.layout.fragment_movie

  override fun toolbarBuilder(): FragmentToolbar {
    return FragmentToolbar.decorateToolbar(R.id.toolbar) {
      withTitle(R.string.movies)
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    showDetailButton.setOnClickListener {
      navController.navigate(
          R.id.action_movies_to_detailFragment,
          bundleOf("titleArg" to "From Movie Fragment")
      )
    }
  }

}
