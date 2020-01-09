package com.taurus.modernandroiddevelopmentkata.main

import android.content.Intent
import android.os.Bundle
import com.taurus.modernandroiddevelopmentkata.R
import com.taurus.modernandroiddevelopmentkata.core.BaseActivity
import com.taurus.modernandroiddevelopmentkata.core.BaseFragment
import com.taurus.modernandroiddevelopmentkata.core.extensions.visibility
import com.taurus.modernandroiddevelopmentkata.core.navigation.BackCommand
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationManager
import com.taurus.modernandroiddevelopmentkata.core.navigation.NavigationViewModel
import com.taurus.modernandroiddevelopmentkata.core.navigation.TabNavigationCommand
import com.taurus.modernandroiddevelopmentkata.navigation.MainNavigator
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity<NavigationViewModel>(
    R.layout.activity_main_single_container,
    NavigationViewModel::class.java
), BaseFragment.FragmentListener {

    @Inject
    lateinit var navigationManager: NavigationManager
    @Inject
    lateinit var navigator: MainNavigator
    @Inject
    lateinit var bottomNavigationViewHolder: BottomNavigationViewHolder
    @Inject
    lateinit var tabContainer: NavigationManager.TabContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        tabContainer.bind()
        navigationManager.bind(viewModel.tabHistory)
        bottomNavigationViewHolder.bind { tabId ->
            navigator.navigate(TabNavigationCommand(tabId))
        }

        handleDeeplinkIntent(intent)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleDeeplinkIntent(intent)
    }

    private fun handleDeeplinkIntent(intent: Intent?) {
        // uncomment to simulate custom deep link handling
//        navigationRouter.navigate(TabNavigationCommand(R.id.navigation_tv_series))
//        navigationRouter.navigate(FromTvSeriesToDetails("from deep link"))
//        navigationRouter.navigate(FromDetailsToSimilarMovies("from deep link"))
    }

    override fun supportNavigateUpTo(upIntent: Intent) {
        navigationManager.navigateUp()
    }

    override fun onBackPressed() {
        navigator.navigate(BackCommand)
    }

    override fun handleBottomBarVisibility(isVisible: Boolean) {
        bottomNavigationView.visibility(isVisible)
    }
}
