package com.taurus.modernandroiddevelopmentkata.favourites

import android.view.View
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar

class FavouriteFragment : BaseFragment<FavouriteStateMachine>() {

    override fun obtainViewModel() = FavouriteStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_favourite

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(R.string.favorites)
        }
    }

    override fun onReadyToRender(view: View, stateMachine: FavouriteStateMachine) {
    }

}
