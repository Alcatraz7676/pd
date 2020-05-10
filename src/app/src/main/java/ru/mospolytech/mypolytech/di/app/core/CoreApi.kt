package ru.mospolytech.mypolytech.di.app.core

import ru.mospolytech.mypolytech.utils.providers.SchedulerProvider

interface CoreApi {
    fun schedulerProvider(): SchedulerProvider
}