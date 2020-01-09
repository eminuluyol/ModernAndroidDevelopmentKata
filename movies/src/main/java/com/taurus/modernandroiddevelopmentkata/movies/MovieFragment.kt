package com.taurus.modernandroiddevelopmentkata.movies

import android.view.View
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.movies.navigation.FromMoviesToDetails
import com.taurus.modernandroiddevelopmentkata.movies.navigation.MovieNavigator
import kotlinx.android.synthetic.main.fragment_movie.*
import javax.inject.Inject

class MovieFragment : BaseFragment<MovieStateMachine>() {

    @Inject
    internal lateinit var navigator: MovieNavigator

    override fun obtainViewModel() = MovieStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_movie

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(R.string.movies)
        }
    }

    override fun onReadyToRender(view: View, stateMachine: MovieStateMachine) {
        showDetailButton.setOnClickListener {
            navigator.navigate(FromMoviesToDetails("From Movies Fragment"))
        }
    }

}
