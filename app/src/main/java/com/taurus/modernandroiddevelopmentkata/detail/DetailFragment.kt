package com.taurus.modernandroiddevelopmentkata.detail

import android.os.Bundle
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.movie.DetailStateMachine

class DetailFragment : BaseFragment<DetailStateMachine>() {

    override fun obtainViewModel() = DetailStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_detail

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(DetailFragmentArgs.fromBundle(arguments!!).fragmentTitle)
        }
    }

    override val isBottomBarEnabled = false

    companion object {
        fun configure(config: DetailFragmentArgs.Builder.() -> Unit): Bundle =
                DetailFragmentArgs.Builder("Detail Fragment")
                        .apply(config)
                        .build()
                        .toBundle()
    }
}
