package com.taurus.modernandroiddevelopmentkata

import android.content.Intent
import android.os.Bundle
import com.taurus.modernandroiddevelopmentkata.core.BaseActivity
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.extensions.visibility
import com.taurus.modernandroiddevelopmentkata.core.navigation.BackCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationRouter
import com.taurus.modernandroiddevelopmentkata.navigation.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<NavigationViewModel>(), BaseFragment.FragmentListener {

    override fun obtainViewModel() = NavigationViewModel::class.java

    @Inject
    lateinit var navigationManager: NavigationManager
    @Inject
    lateinit var navigationRouter: NavigationRouter
    @Inject
    lateinit var mainActivityViewContainer: MainActivityViewContainer

    override fun layoutResId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navigationManager.bind(TabHistory(R.id.navigation_movies))
        mainActivityViewContainer.bind { tabId ->
            navigationRouter.navigate(TabNavigationCommand(tabId))
        }

//        viewModel.navigationRouter.nonNullObserveEvent(this) {
//            navigationRouterFacade.process(it)
//        }
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        navigationManager.supportNavigateUp()
    }

    override fun onBackPressed() {
        navigationRouter.navigate(BackCommand)
    }

    override fun handleBottomBarVisibility(isVisible: Boolean) {
        bottomNavigationView.visibility(isVisible)
    }
}
