package com.taurus.modernandroiddevelopmentkata.movies

import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : BaseFragment<MovieStateMachine>() {


    override fun obtainViewModel() = MovieStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_movie

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(R.string.movies)
        }
    }

    override fun onReadyToRender(view: View, stateMachine: MovieStateMachine, navController: NavController) {
        showDetailButton.setOnClickListener {
            navController.navigate(
                R.id.navigation_graph_details,
                bundleOf("titleArg" to "From Movie Fragment")
            )
        }
    }
}
