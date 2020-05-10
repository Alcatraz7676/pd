package ru.mospolytech.mypolytech.ui.base

import moxy.MvpPresenter
import moxy.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class RxPresenter<T : MvpView> : MvpPresenter<T>() {

    protected val subscriptions = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        subscriptions.clear()
    }

    fun Disposable.store() = subscriptions.add(this)
}
