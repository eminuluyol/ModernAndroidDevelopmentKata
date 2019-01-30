package com.taurus.modernandroiddevelopmentkata.detail

import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.movie.DetailStateMachine

class DetailFragment : BaseFragment<DetailStateMachine>() {

  override fun getViewModel() = DetailStateMachine::class.java

  override fun layoutResId() = R.layout.fragment_detail

  override fun toolbarBuilder(): FragmentToolbar {
    return FragmentToolbar.decorateToolbar(R.id.toolbar) {
      // no op
    }
  }

}
