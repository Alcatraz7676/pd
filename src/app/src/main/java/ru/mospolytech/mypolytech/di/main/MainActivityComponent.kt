package ru.mospolytech.mypolytech.di.main

import dagger.Subcomponent
import ru.mospolytech.mypolytech.di.main.flow.MainFlowComponent
import ru.mospolytech.mypolytech.ui.main.MainActivity

@Subcomponent
interface MainActivityComponent {

    fun inject(activity: MainActivity)
}
