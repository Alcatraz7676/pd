package ru.mospolytech.mypolytech.di.app

import dagger.BindsInstance
import dagger.Component
import ru.mospolytech.mypolytech.app.MyPolytechApp
import ru.mospolytech.mypolytech.di.app.core.CoreApi
import ru.mospolytech.mypolytech.di.main.MainActivityComponent
import ru.mospolytech.mypolytech.di.main.flow.MainFlowComponent
import ru.mospolytech.mypolytech.di.splash.SplashComponent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NavigationModule::class
    ],
    dependencies = [
        CoreApi::class
    ]
)
interface AppComponent : CoreApi {

    fun mainActivityComponent(): MainActivityComponent
    fun splashComponent(): SplashComponent

    fun mainFlowComponent(): MainFlowComponent

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindApplication(app: MyPolytechApp): Builder
        fun coreApi(coreApi: CoreApi): Builder
        fun build(): AppComponent
    }
}