package com.taurus.modernandroiddevelopmentkata.movies

import android.view.View
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.navigation.Navigator
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.movies.navigation.FromMoviesToDetails
import kotlinx.android.synthetic.main.fragment_movie.view.showDetailButton
import javax.inject.Inject

class MovieFragment : BaseFragment<MovieStateMachine>() {

    @Inject
    lateinit var navigator: Navigator

    override fun obtainViewModel() = MovieStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_movie

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(R.string.movies)
        }
    }

    override fun onReadyToRender(view: View, stateMachine: MovieStateMachine) {
        view.showDetailButton.setOnClickListener {
            navigator.navigate(FromMoviesToDetails("From Movies Fragment"))
        }
    }

}
