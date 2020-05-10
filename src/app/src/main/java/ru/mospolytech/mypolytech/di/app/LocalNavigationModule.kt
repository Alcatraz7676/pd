package ru.mospolytech.mypolytech.di.app

import dagger.Module
import dagger.Provides
import ru.mospolytech.mypolytech.di.scopes.PerActivityScope
import ru.mospolytech.mypolytech.utils.navigation.cicerone.LocalNavigation
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

@Module
class LocalNavigationModule {

    @Provides
    @PerActivityScope
    @LocalNavigation
    fun provideLocalRouter(@LocalNavigation cicerone: Cicerone<Router>): Router = cicerone.router

    @Provides
    @PerActivityScope
    @LocalNavigation
    fun provideLocalCicerone(): Cicerone<Router> = Cicerone.create(Router())

    @Provides
    @PerActivityScope
    @LocalNavigation
    fun provideLocalNavigatorHolder(@LocalNavigation cicerone: Cicerone<Router>) = cicerone.navigatorHolder
}
