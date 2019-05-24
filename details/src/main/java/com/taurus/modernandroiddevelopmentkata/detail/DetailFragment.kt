package com.taurus.modernandroiddevelopmentkata.detail

import android.view.View
import com.taurus.details.R
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.navigation.Navigator
import com.taurus.modernandroiddevelopmentkata.core.toolbar.FragmentToolbar
import com.taurus.modernandroiddevelopmentkata.detail.DetailFragmentArgs.fromBundle
import com.taurus.modernandroiddevelopmentkata.detail.navigation.DetailsNavigator
import com.taurus.modernandroiddevelopmentkata.detail.navigation.FromDetailsToSimilarMovies
import kotlinx.android.synthetic.main.fragment_detail.showSimilarMoviesButton
import javax.inject.Inject

internal class DetailFragment : BaseFragment<DetailStateMachine>() {

    @Inject
    internal lateinit var navigator: DetailsNavigator

    private val title by lazy {
        // required arg -> force non-nullability
        fromBundle(arguments!!).title
    }

    override fun obtainViewModel() = DetailStateMachine::class.java

    override fun layoutResId() = R.layout.fragment_detail

    override fun toolbarBuilder(): FragmentToolbar {
        return FragmentToolbar.decorateToolbar(R.id.toolbar) {
            withTitle(title)
            onHomePressedDefaultAction()
        }
    }

    override val isBottomBarEnabled = true

    override fun onReadyToRender(view: View, stateMachine: DetailStateMachine) {
        showSimilarMoviesButton.setOnClickListener {
            navigator.navigate(FromDetailsToSimilarMovies("From Details Fragment"))
        }
    }

}
