package com.taurus.modernandroiddevelopmentkata.tvseries

import android.view.View
import androidx.navigation.NavController
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import kotlinx.android.synthetic.main.fragment_tv_series.showDetailButton

class TVSeriesFragment : com.taurus.modernandroiddevelopmentkata.core.BaseFragment<TVSeriesStateMachine>() {

    override fun obtainViewModel() = TVSeriesStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_tv_series

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(R.string.tv_series)
        }
    }

    override fun onReadyToRender(view: View, stateMachine: TVSeriesStateMachine,
        navController: NavController) {
        showDetailButton.setOnClickListener {
            val action = TVSeriesFragmentDirections.navigateFromTvSeriesToDetails(
                "From TV Series Fragment"
            )
            navController.navigate(action)
        }
    }

}
