package com.gontharuk.wperdenazakupy.model.core

interface Mapper<A, B> {

    fun mapA(input: A): Result<B>

    fun mapB(input: B): Result<A>
}