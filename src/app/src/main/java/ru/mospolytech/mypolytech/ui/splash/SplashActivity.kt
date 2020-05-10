package ru.mospolytech.mypolytech.ui.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import ru.mospolytech.mypolytech.R
import ru.mospolytech.mypolytech.di.app.AppComponent
import ru.mospolytech.mypolytech.di.splash.SplashComponent
import ru.mospolytech.mypolytech.utils.common_registry.ComponentRegistry
import ru.mospolytech.mypolytech.utils.navigation.BasicNavigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject
import javax.inject.Provider

class SplashActivity : MvpAppCompatActivity(), SplashView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = BasicNavigator(this, 0)

    @Inject
    lateinit var presenterProvider: Provider<SplashPresenter>

    private val presenter: SplashPresenter by moxyPresenter { presenterProvider.get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    private fun inject() {
        ComponentRegistry.get<AppComponent>()
            .splashComponent()
            .inject(this)
    }

    companion object {
        fun getIntent(context: Context): Intent? {
            return Intent(context, SplashActivity::class.java)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
    }
}