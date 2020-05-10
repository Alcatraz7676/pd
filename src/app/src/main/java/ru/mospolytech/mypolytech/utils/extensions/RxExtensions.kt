package ru.mospolytech.mypolytech.utils.extensions

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.addTo(compositeDisposable: CompositeDisposable): Disposable {
    return apply { compositeDisposable.add(this) }
}