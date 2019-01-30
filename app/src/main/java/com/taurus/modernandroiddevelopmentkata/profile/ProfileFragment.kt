package com.taurus.modernandroiddevelopmentkata.profile

import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.movie.ProfileStateMachine


class ProfileFragment : BaseFragment<ProfileStateMachine>() {

  override fun obtainViewModel() = ProfileStateMachine::class.java

  override fun layoutResId() = R.layout.fragment_profile

  override fun toolbarBuilder(): FragmentToolbar {
    return FragmentToolbar.decorateToolbar(R.id.toolbar) {
      withTitle(R.string.profile)
    }
  }

}