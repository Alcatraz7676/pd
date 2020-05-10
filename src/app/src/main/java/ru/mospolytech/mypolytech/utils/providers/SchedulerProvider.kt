package ru.mospolytech.mypolytech.utils.providers

import io.reactivex.Scheduler

interface SchedulerProvider {

    val ui: Scheduler
        get() = ui()
    val network: Scheduler
        get() = network()
    val io: Scheduler
        get() = io()

    fun ui(): Scheduler
    fun network(): Scheduler
    fun io(): Scheduler
}