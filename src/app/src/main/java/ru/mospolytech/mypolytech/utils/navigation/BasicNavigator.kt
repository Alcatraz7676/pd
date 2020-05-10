package ru.mospolytech.mypolytech.utils.navigation

import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import ru.mospolytech.mypolytech.app.Screens
import ru.mospolytech.mypolytech.ui.main.MainActivity
import ru.mospolytech.mypolytech.ui.splash.SplashActivity
import ru.mospolytech.mypolytech.utils.navigation.cicerone.SupportAppNavigator

open class BasicNavigator @JvmOverloads constructor(
    private val activity: FragmentActivity,
    containerId: Int,
    private val funCreateFragment: ((String, Any?) -> Fragment?)? = null
) : SupportAppNavigator(activity, containerId) {

    override fun createActivityIntent(screenKey: String?, data: Any?): Intent? {
        return when (screenKey) {
            Screens.SPLASH_ACTIVITY -> SplashActivity.getIntent(activity)
            Screens.MAIN_ACTIVITY -> MainActivity.getIntent(activity)
            else -> null
        }
    }

    override fun createFragment(screenKey: String, data: Any?): Fragment? {
        return funCreateFragment?.invoke(screenKey, data)
    }
}
