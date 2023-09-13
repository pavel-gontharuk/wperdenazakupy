package com.gontharuk.wperdenazakupy.domain.usecase.bucket

import com.gontharuk.wperdenazakupy.domain.model.Bucket
import com.gontharuk.wperdenazakupy.domain.repository.BucketRepository
import javax.inject.Inject

class BucketUseCaseImpl @Inject constructor(
    private val bucketRepository: BucketRepository
) : BucketUseCase {

    override suspend fun put(vararg bucket: Bucket) {
        bucketRepository.put(*bucket)
    }

    override suspend fun getAllKey(key: String): List<Bucket> {
        return bucketRepository.getAllKey(key)
    }

    override suspend fun getAll(): List<Bucket> {
        return bucketRepository.getAll()
    }
}