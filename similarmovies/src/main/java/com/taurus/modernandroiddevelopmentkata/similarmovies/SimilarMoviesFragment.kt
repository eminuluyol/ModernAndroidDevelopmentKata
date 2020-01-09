package com.taurus.modernandroiddevelopmentkata.similarmovies

import android.view.View
import androidx.navigation.fragment.navArgs
import com.taurus.details.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar

internal class SimilarMoviesFragment : BaseFragment<SimilarMoviesMachine>() {

    private val args: SimilarMoviesFragmentArgs by navArgs()

    override fun obtainViewModel() = SimilarMoviesMachine::class.java

    override fun layoutResId() = R.layout.fragment_similar_movies

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(args.title)
            onHomePressedDefaultAction()
        }
    }

    override val isBottomBarEnabled = false

    override fun onReadyToRender(view: View, stateMachine: SimilarMoviesMachine) {
    }

}
