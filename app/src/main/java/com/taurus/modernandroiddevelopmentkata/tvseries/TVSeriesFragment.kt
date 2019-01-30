package com.taurus.modernandroiddevelopmentkata.tvseries

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.movie.TVSeriesStateMachine
import kotlinx.android.synthetic.main.fragment_tv_series.showDetailButton

class TVSeriesFragment : BaseFragment<TVSeriesStateMachine>() {

  override fun obtainViewModel() = TVSeriesStateMachine::class.java

  override fun layoutResId() = R.layout.fragment_tv_series

  override fun toolbarBuilder(): FragmentToolbar {
    return FragmentToolbar.decorateToolbar(R.id.toolbar) {
      withTitle(R.string.tv_series)
    }
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    showDetailButton.setOnClickListener {
      navController.navigate(
          R.id.action_tv_series_to_detailFragment,
          bundleOf("titleArg" to "From TV Series Fragment")

      )
    }
  }

}
