package ru.mospolytech.mypolytech.ui.main.flow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import moxy.ktx.moxyPresenter
import ru.mospolytech.mypolytech.R
import ru.mospolytech.mypolytech.app.Screens
import ru.mospolytech.mypolytech.di.app.AppComponent
import ru.mospolytech.mypolytech.di.main.flow.MainFlowComponent
import ru.mospolytech.mypolytech.ui.base.HostFragment
import ru.mospolytech.mypolytech.ui.tabs.TabsFragment
import ru.mospolytech.mypolytech.utils.common_registry.ComponentRegistry
import ru.mospolytech.mypolytech.utils.navigation.cicerone.LocalNavigation
import ru.mospolytech.mypolytech.utils.navigation.cicerone.SupportAppNavigator
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Inject
import javax.inject.Provider

class MainFlowFragment : HostFragment(), MainFlowView {

    @Inject
    override lateinit var globalRouter: Router

    @Inject
    @field:LocalNavigation
    lateinit var navigatorHolder: NavigatorHolder

    private lateinit var navigator: Navigator

    @Inject
    lateinit var presenterProvider: Provider<MainFlowPresenter>

    private val presenter: MainFlowPresenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        navigator = getNavigator()
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onFinish() {
        ComponentRegistry.clear<MainFlowComponent>()
        super.onFinish()
    }

    private fun inject() = with(ComponentRegistry) {
        get<AppComponent>()
            .mainFlowComponent()
            .also { replaceComponentIfExists(component = it) }
            .inject(this@MainFlowFragment)
    }

    private fun getNavigator(): Navigator {
        return object : SupportAppNavigator(activity, childFragmentManager, R.id.content) {

            override fun createActivityIntent(screenKey: String?, data: Any?): Intent? = null

            override fun createFragment(screenKey: String?, data: Any?): Fragment? {
                return when (screenKey) {
                    Screens.TABS_FRAGMENT -> TabsFragment()
                    else -> null
                }
            }

            override fun exit() {
                globalRouter.exit()
            }
        }
    }
}