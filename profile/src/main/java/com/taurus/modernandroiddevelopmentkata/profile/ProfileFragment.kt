package com.taurus.modernandroiddevelopmentkata.profile

import android.view.View
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.profile.R

class ProfileFragment : BaseFragment<ProfileStateMachine>() {

    override fun obtainViewModel() = ProfileStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_profile

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(R.string.profile)
        }
    }

    override fun onReadyToRender(view: View, stateMachine: ProfileStateMachine) {
    }

}
