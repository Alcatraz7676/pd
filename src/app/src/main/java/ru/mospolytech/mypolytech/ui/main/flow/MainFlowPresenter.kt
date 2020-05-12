package ru.mospolytech.mypolytech.ui.main.flow

import ru.mospolytech.mypolytech.app.Screens
import ru.mospolytech.mypolytech.ui.base.RxPresenter
import ru.mospolytech.mypolytech.utils.navigation.cicerone.LocalNavigation
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class MainFlowPresenter @Inject constructor(
    @LocalNavigation private val localRouter: Router
) : RxPresenter<MainFlowView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        localRouter.replaceScreen(Screens.TABS_FRAGMENT)
    }
}