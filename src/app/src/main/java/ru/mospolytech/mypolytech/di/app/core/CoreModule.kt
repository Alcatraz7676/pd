package ru.mospolytech.mypolytech.di.app.core

import dagger.Binds
import dagger.Module
import ru.mospolytech.mypolytech.utils.providers.AppSchedulers
import ru.mospolytech.mypolytech.utils.providers.SchedulerProvider

@Module
interface CoreModule {

    @Binds
    fun bindSchedulers(impl: AppSchedulers): SchedulerProvider
}