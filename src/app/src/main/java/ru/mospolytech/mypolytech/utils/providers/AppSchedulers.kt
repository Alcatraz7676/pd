package ru.mospolytech.mypolytech.utils.providers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import javax.inject.Inject

class AppSchedulers @Inject constructor() : SchedulerProvider {

    override fun ui(): Scheduler = AndroidSchedulers.mainThread()

    override fun network(): Scheduler = Schedulers.from(Executors.newFixedThreadPool(65))

    override fun io(): Scheduler = Schedulers.io()
}