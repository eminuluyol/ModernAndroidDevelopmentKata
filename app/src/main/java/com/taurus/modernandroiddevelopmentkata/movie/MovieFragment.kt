package com.taurus.modernandroiddevelopmentkata.movie

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_movie.*

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
            val args = DetailFragment.configure {
                fragmentTitle = "Some Movie"
            }

            findNavController().navigate(R.id.action_movieFragment_to_detailFragment, args)
        }
    }

}
