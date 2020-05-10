package ru.mospolytech.mypolytech.di.main.flow

import dagger.Subcomponent
import ru.mospolytech.mypolytech.di.app.LocalNavigationModule
import ru.mospolytech.mypolytech.di.example.ExampleComponent
import ru.mospolytech.mypolytech.di.scopes.PerActivityScope
import ru.mospolytech.mypolytech.ui.main.flow.MainFlowFragment

@Subcomponent(modules = [LocalNavigationModule::class])
@PerActivityScope
interface MainFlowComponent {

    fun inject(fragment: MainFlowFragment)

    fun exampleComponent(): ExampleComponent
}