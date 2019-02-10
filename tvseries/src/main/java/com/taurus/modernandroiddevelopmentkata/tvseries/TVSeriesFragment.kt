package com.taurus.modernandroiddevelopmentkata.tvseries

import android.view.View
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationRouter
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.tvseries.navigation.NavigateFromTvSeriesToDetails
import kotlinx.android.synthetic.main.fragment_tv_series.*
import javax.inject.Inject

class TVSeriesFragment : BaseFragment<TVSeriesStateMachine>() {

    @Inject
    lateinit var navigationRouter: NavigationRouter

    override fun obtainViewModel() = TVSeriesStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_tv_series

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(R.string.tv_series)
        }
    }

    override fun onReadyToRender(view: View, stateMachine: TVSeriesStateMachine) {
        showDetailButton.setOnClickListener {
            navigationRouter.navigate(NavigateFromTvSeriesToDetails("From TV Series Fragment"))
        }
    }

}
