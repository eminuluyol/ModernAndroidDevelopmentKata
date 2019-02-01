package com.taurus.modernandroiddevelopmentkata.tvseries

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.detail.DetailFragment
import com.taurus.modernandroiddevelopmentkata.movie.TVSeriesStateMachine
import kotlinx.android.synthetic.main.fragment_tv_series.*

class TVSeriesFragment : BaseFragment<TVSeriesStateMachine>() {

    override fun obtainViewModel() = TVSeriesStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_tv_series

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(R.string.tv_series)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDetailButton.setOnClickListener {
            val args = DetailFragment.configure {
                fragmentTitle = "Some Show"
            }
            findNavController()
                    .navigate(R.id.action_TVSeriesFragment_to_detailFragment, args)
        }
    }

}
