package com.gontharuk.wperdenazakupy.ui.core.view

fun interface Listener<T> {

    fun onEvent(value: T)
}