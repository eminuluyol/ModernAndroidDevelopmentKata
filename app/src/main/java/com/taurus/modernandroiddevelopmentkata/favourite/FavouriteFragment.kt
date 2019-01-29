package com.taurus.modernandroiddevelopmentkata.favourite

import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.movie.FavouriteStateMachine


class FavouriteFragment : BaseFragment<FavouriteStateMachine>() {

  override fun getViewModel() = FavouriteStateMachine::class.java

  override fun layoutResId() = R.layout.fragment_favourite

  override fun toolbarBuilder(): FragmentToolbar {
    return FragmentToolbar.decorateToolbar(R.id.toolbar) {
      withTitle(R.string.nav_favorites)
    }
  }

}