package ru.mospolytech.mypolytech.utils.extensions

inline fun consume(f: () -> Unit) = f().let { true }