package com.gontharuk.wperdenazakupy.model.core

interface Mapper<I, O> {

    fun map(data: I): O
}