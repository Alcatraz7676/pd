package ru.mospolytech.mypolytech.di.example

import dagger.Subcomponent
import ru.mospolytech.mypolytech.ui.example.ExampleFragment

@Subcomponent
interface ExampleComponent {

    fun inject(fragment: ExampleFragment)
}