package ru.mospolytech.mypolytech.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.mospolytech.mypolytech.R
import ru.mospolytech.mypolytech.app.Screens
import ru.mospolytech.mypolytech.di.app.AppComponent
import ru.mospolytech.mypolytech.ui.base.Transitions
import ru.mospolytech.mypolytech.ui.main.flow.MainFlowFragment
import ru.mospolytech.mypolytech.utils.common_registry.ComponentRegistry
import ru.mospolytech.mypolytech.utils.navigation.BasicNavigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.commands.Command
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var presenterProvider: Provider<MainPresenter>

    private val presenter: MainPresenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_host)
    }

    private fun inject() {
        ComponentRegistry.get<AppComponent>()
            .mainActivityComponent()
            .inject(this)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(getNavigator())
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun getNavigator() =
        object : BasicNavigator(this, R.id.content, ::createFragment) {

            override fun setupFragmentTransactionAnimation(
                command: Command?,
                currentFragment: Fragment?,
                nextFragment: Fragment?,
                fragmentTransaction: FragmentTransaction?
            ) {

                nextFragment?.enterTransition = when (nextFragment) {
                    is MainFlowFragment -> Transitions.fromEnd()
                    else -> null
                }

                currentFragment?.exitTransition = when (nextFragment) {
                    is MainFlowFragment -> Transitions.fade()
                    else -> null
                }
            }
        }

    private fun createFragment(screenKey: String?, data: Any?): Fragment? {
        return when (screenKey) {
            Screens.MAIN_FRAGMENT_FLOW -> MainFlowFragment()
            else -> null
        }
    }

    companion object {
        fun getIntent(context: Context): Intent? {
            return Intent(context, MainActivity::class.java)
        }
    }
}
