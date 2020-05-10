package ru.mospolytech.mypolytech.ui.example

import android.os.Bundle
import ru.mospolytech.mypolytech.R
import ru.mospolytech.mypolytech.di.example.ExampleComponent
import ru.mospolytech.mypolytech.di.main.flow.MainFlowComponent
import ru.mospolytech.mypolytech.ui.base.BaseFragment
import ru.mospolytech.mypolytech.utils.common_registry.ComponentRegistry
import ru.mospolytech.mypolytech.utils.common_registry.ComponentRegistry.get
import ru.mospolytech.mypolytech.utils.common_registry.ComponentRegistry.replaceComponentIfExists

class ExampleFragment : BaseFragment() {

    override val layoutRes = R.layout.fragment_example

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
    }

    override fun onFinish() {
        ComponentRegistry.clear<ExampleComponent>()
        super.onFinish()
    }

    private fun inject() {
        get<MainFlowComponent>()
            .exampleComponent()
            .also { replaceComponentIfExists(component = it) }
            .inject(this)
    }
}