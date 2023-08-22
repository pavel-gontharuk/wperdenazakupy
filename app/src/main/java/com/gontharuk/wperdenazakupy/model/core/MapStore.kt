package com.gontharuk.wperdenazakupy.model.core

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

abstract class MapStore<K, V> : Store<K, V> {

    private val store: HashMap<K, V> = HashMap()

    override fun put(key: K, value: V): Flow<Result<Unit>> {
        val result: Result<Unit> = if (!store.containsKey(key)) {
            store[key] = value
            Result.success(Unit)
        } else {
            Result.failure(Throwable("Key already exists : $key"))
        }
        return flowOf(result)
    }

    override fun get(key: K): Flow<Result<V>> {
        val result: Result<V> = if (store.containsKey(key)) {
            Result.success(store[key]!!)
        } else {
            Result.failure(Throwable("Key does not exists : $key"))
        }
        return flowOf(result)
    }

    override fun delete(key: K): Flow<Result<Unit>> {
        val result: Result<Unit> = if (store.remove(key) != null) {
            Result.success(Unit)
        } else {
            Result.failure(Throwable("Key does not exists : $key"))
        }
        return flowOf(result)
    }

    override fun getAll(): Flow<Result<List<V>>> {
        val result: Result<List<V>> = if (store.isNotEmpty()) {
            Result.success(store.map { it.value })
        } else {
            Result.failure(Throwable("Store is empty"))
        }
        return flowOf(result)
    }

    override fun clear(): Flow<Result<Unit>> {
        store.clear()
        return flowOf(Result.success(Unit))
    }
}