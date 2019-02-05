package com.taurus.modernandroiddevelopmentkata.detail

import android.view.View
import androidx.navigation.NavController
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.detail.DetailFragmentArgs.fromBundle

class DetailFragment : BaseFragment<DetailStateMachine>() {

    private val title by lazy {
        fromBundle(arguments!!).titleArg
    }

    override fun obtainViewModel() = DetailStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_detail

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(title)
            onHomePressedDefaultAction()
        }
    }

    override val isBottomBarEnabled = false

    override fun onReadyToRender(view: View, stateMachine: DetailStateMachine, navController: NavController) {
    }

}
