package com.taurus.modernandroiddevelopmentkata.series

import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.movie.TVSeriesStateMachine


class TVSeriesFragment : BaseFragment<TVSeriesStateMachine>() {

  override fun getViewModel() = TVSeriesStateMachine::class.java

  override fun layoutResId() = R.layout.fragment_tv_series

  override fun toolbarBuilder(): FragmentToolbar {
    return FragmentToolbar.decorateToolbar(R.id.toolbar) {
      withTitle(R.string.nav_tv)
    }
  }

}