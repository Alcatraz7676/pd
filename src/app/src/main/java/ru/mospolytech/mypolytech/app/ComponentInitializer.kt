package ru.mospolytech.mypolytech.app

import ru.mospolytech.mypolytech.di.app.DaggerAppComponent
import ru.mospolytech.mypolytech.di.app.core.CoreApi
import ru.mospolytech.mypolytech.di.app.core.DaggerCoreComponent
import ru.mospolytech.mypolytech.utils.common_registry.ComponentRegistry

class ComponentInitializer(private val app: MyPolytechApp) {

    fun initAppComponent() {
        DaggerAppComponent.builder()
            .bindApplication(app)
            .coreApi(getCoreApi())
            .build()
            .registerComponent()
    }

    private fun getCoreApi(): CoreApi {
        return DaggerCoreComponent.builder()
            .build()
            .registerComponent<CoreApi>()
    }

    private inline fun <reified T : Any> T.registerComponent(): T {
        return if (ComponentRegistry.hasComponent<T>()) {
            ComponentRegistry.get()
        } else {
            ComponentRegistry.register { this }
            this
        }
    }
}
