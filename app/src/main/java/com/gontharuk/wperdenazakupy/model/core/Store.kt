package com.gontharuk.wperdenazakupy.model.core

import kotlinx.coroutines.flow.Flow

interface Store<K, V> {

    fun put(key: K, value: V): Flow<Result<Unit>>

    fun get(key: K): Flow<Result<V>>

    fun delete(key: K): Flow<Result<Unit>>

    fun getAll(): Flow<Result<List<V>>>

    fun clear(): Flow<Result<Unit>>
}