package com.gontharuk.wperdenazakupy.model.core.mapstore

fun interface WriteStrategy<T> {

    fun decide(new: T?, existing: T?): Result<T>
}