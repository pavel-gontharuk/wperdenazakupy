package com.gontharuk.wperdenazakupy.presentation.core.view

fun interface Listener<T> {

    fun onEvent(value: T)
}