package ru.mospolytech.mypolytech.di.splash

import dagger.Subcomponent
import ru.mospolytech.mypolytech.ui.splash.SplashActivity

@Subcomponent
interface SplashComponent {

    fun inject(activity: SplashActivity)
}
