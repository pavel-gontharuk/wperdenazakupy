package com.gontharuk.wperdenazakupy.data.database.bucket

import com.gontharuk.wperdenazakupy.domain.model.Bucket
import com.gontharuk.wperdenazakupy.domain.repository.BucketRepository
import javax.inject.Inject

class BucketRepositoryImpl @Inject constructor(
    private val dao: BucketDao
) : BucketRepository {

    override suspend fun put(vararg bucket: Bucket) {
        bucket.map { it.toEntity() }
            .toTypedArray()
            .also { dao.put(*it) }
    }

    override suspend fun getAll(): List<Bucket> {
        return dao.getAll()
            .map { it.toModel() }
    }

    override suspend fun getAllKey(key: String): List<Bucket> {
        return dao.getAllKey(key)
            .map { it.toModel() }
    }

    override suspend fun delete(bucket: Bucket) {
        TODO("Not yet implemented")
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }
}