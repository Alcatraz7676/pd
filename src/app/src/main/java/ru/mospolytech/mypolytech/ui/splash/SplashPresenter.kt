package ru.mospolytech.mypolytech.ui.splash

import io.reactivex.Single
import ru.mospolytech.mypolytech.app.Screens
import ru.mospolytech.mypolytech.ui.base.RxPresenter
import ru.mospolytech.mypolytech.utils.extensions.addTo
import ru.mospolytech.mypolytech.utils.providers.SchedulerProvider
import ru.terrakok.cicerone.Router
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class SplashPresenter @Inject constructor(
    private val router: Router,
    private val schedulers: SchedulerProvider
) : RxPresenter<SplashView>() {

    override fun attachView(view: SplashView?) {
        super.attachView(view)
        // TODO REMOVE DELAY
        Single.timer(2L, TimeUnit.SECONDS)
            .subscribeOn(schedulers.io)
            .observeOn(schedulers.ui)
            .subscribe { _ ->
                router.newRootScreen(Screens.MAIN_ACTIVITY)
            }
            .addTo(subscriptions)
    }
}
