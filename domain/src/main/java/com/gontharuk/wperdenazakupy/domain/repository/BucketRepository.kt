package com.gontharuk.wperdenazakupy.domain.repository

import com.gontharuk.wperdenazakupy.domain.model.Bucket

interface BucketRepository {

    suspend fun put(vararg bucket: Bucket)

    suspend fun getAll(): List<Bucket>

    suspend fun getAllKey(key: String): List<Bucket>

    suspend fun delete(bucket: Bucket)

    suspend fun clear()
}