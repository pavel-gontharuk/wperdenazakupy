package com.gontharuk.wperdenazakupy.domain.usecase.bucket

import com.gontharuk.wperdenazakupy.domain.model.Bucket

interface BucketUseCase {

    suspend fun put(vararg bucket: Bucket)

    suspend fun getAll(): List<Bucket>

    suspend fun getAllKey(key: String): List<Bucket>
}