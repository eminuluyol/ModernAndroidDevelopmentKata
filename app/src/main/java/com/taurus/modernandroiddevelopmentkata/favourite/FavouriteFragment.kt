package com.taurus.modernandroiddevelopmentkata.favourite

import android.view.View
import androidx.navigation.NavController
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar


class FavouriteFragment : com.taurus.modernandroiddevelopmentkata.core.BaseFragment<FavouriteStateMachine>() {

    override fun obtainViewModel() = FavouriteStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_favourite

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(R.string.favorites)
        }
    }

    override fun onReadyToRender(view: View, stateMachine: FavouriteStateMachine, navController: NavController) {
    }

}
