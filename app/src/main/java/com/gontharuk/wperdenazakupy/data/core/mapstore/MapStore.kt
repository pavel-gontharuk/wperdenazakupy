package com.gontharuk.wperdenazakupy.data.core.mapstore

import com.gontharuk.core.data.Store
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class MapStore<K, V> : Store<K, V> {

    private val store: HashMap<K, V> = HashMap()

    override fun put(key: K, value: V): Flow<Unit> = flow {
        store[key] = value
        emit(Unit)
    }

    override fun get(key: K): Flow<V> = flow {
        store.getOrElse(key) {
            throw Throwable("Item does not exists : $key")
        }.also { emit(it) }
    }

    override fun delete(key: K): Flow<Unit> = flow {
        store.remove(key).also {
            if (it == null) throw Throwable("Item does not exists : $key")
        }
        emit(Unit)
    }

    override fun getAll(): Flow<List<V>> = flow {
        store.map {
            it.value
        }.also { list ->
            if (list.isEmpty()) throw Throwable("Store is empty")
            else emit(list)
        }
    }

    override fun clear(): Flow<Unit> = flow {
        store.clear()
        emit(Unit)
    }
}