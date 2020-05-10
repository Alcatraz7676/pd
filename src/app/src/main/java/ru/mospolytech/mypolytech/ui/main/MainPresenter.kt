package ru.mospolytech.mypolytech.ui.main

import ru.mospolytech.mypolytech.app.Screens
import ru.mospolytech.mypolytech.ui.base.RxPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val router: Router
) : RxPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.MAIN_FRAGMENT_FLOW)
    }
}
