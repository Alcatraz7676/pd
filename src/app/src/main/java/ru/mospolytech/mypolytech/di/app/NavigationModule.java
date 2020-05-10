package ru.mospolytech.mypolytech.di.app;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

@Module
public class NavigationModule {

    @Provides
    @Singleton
    Cicerone<Router> provideCicerone() {
        return Cicerone.create(new Router());
    }

    @Provides
    @Singleton
    NavigatorHolder provideHolder(Cicerone<Router> cicerone) {
        return cicerone.getNavigatorHolder();
    }

    @Provides
    @Singleton
    Router provideRouter(Cicerone<Router> cicerone) {
        return cicerone.getRouter();
    }


}
