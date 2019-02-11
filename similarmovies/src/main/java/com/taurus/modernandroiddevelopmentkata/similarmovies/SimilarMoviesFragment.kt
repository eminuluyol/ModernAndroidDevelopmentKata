package com.taurus.modernandroiddevelopmentkata.similarmovies

import android.view.View
import com.taurus.details.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.similarmovies.SimilarMoviesFragmentArgs.fromBundle

class SimilarMoviesFragment : BaseFragment<SimilarMoviesMachine>() {

    private val title by lazy {
        // required arg -> force non-nullability
        fromBundle(arguments!!).title
    }

    override fun obtainViewModel() = SimilarMoviesMachine::class.java

    override fun layoutResId() = R.layout.fragment_similar_movies

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(title)
            onHomePressedDefaultAction()
        }
    }

    override val isBottomBarEnabled = false

    override fun onReadyToRender(view: View, stateMachine: SimilarMoviesMachine) {
    }

}
