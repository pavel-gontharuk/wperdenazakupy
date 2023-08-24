package com.gontharuk.wperdenazakupy.data.coroutines

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.flow.Flow

suspend fun <T> Flow<T>.collectDeferred(): T {
    val deferred = CompletableDeferred<T>()

    this.collect {
        deferred.complete(it)
    }

    return deferred.await()
}