package ru.mospolytech.mypolytech.di.example

import dagger.Subcomponent
import ru.mospolytech.mypolytech.ui.tabs.TabsFragment

@Subcomponent
interface TabsComponent {

    fun inject(fragment: TabsFragment)
}