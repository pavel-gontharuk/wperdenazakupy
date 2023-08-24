package com.gontharuk.wperdenazakupy.model.core.mapstore

import com.gontharuk.wperdenazakupy.model.core.Store
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

abstract class MapStore<K, V> : Store<K, V> {

    // TODO need flexible solution for strategies
    private val putStrategy: WriteStrategy<V> = WriteStrategy { new, _ ->
        Result.success(new!!)
    }
    private val getStrategy: ReadStrategy<V> = ReadStrategy { existing ->
        Result.success(existing!!)
    }
    private val deleteStrategy: ReadStrategy<Unit> = ReadStrategy {
        Result.success(Unit)
    }
    private val getAllStrategy: ReadStrategy<List<V>> = ReadStrategy { existing ->
        Result.success(existing!!)
    }

    private val store: HashMap<K, V> = HashMap()

    override fun put(key: K, value: V): Flow<Result<Unit>> {
        val result: Result<Unit> = putStrategy.decide(
            new = value,
            existing = store.getOrDefault(key, null),
        ).map {
            store[key] = it
        }
        return flowOf(result)
    }

    override fun get(key: K): Flow<Result<V>> {
        val result: Result<V> = getStrategy.decide(
            existing = store.getOrDefault(key, null)
        )
        return flowOf(result)
    }

    override fun delete(key: K): Flow<Result<Unit>> {
        val result: Result<Unit> = deleteStrategy.decide(
            existing = null
        ).map {
            store.remove(key)
        }
        return flowOf(result)
    }

    override fun getAll(): Flow<Result<List<V>>> {
        val result: Result<List<V>> = getAllStrategy.decide(
            existing = store.map { it.value }
        )
        return flowOf(result)
    }

    override fun clear(): Flow<Result<Unit>> {
        store.clear()
        return flowOf(Result.success(Unit))
    }
}