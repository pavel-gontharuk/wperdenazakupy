package com.gontharuk.wperdenazakupy.model.core.mapstore

fun interface ReadStrategy<T> {

    fun decide(existing: T?): Result<T>
}