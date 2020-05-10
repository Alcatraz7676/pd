package ru.mospolytech.mypolytech.di.app.core

import dagger.Component

@Component(
    modules = [CoreModule::class]
)
interface CoreComponent : CoreApi