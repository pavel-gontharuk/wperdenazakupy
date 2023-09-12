package com.gontharuk.wperdenazakupy.data.database.purchaselist

import com.gontharuk.wperdenazakupy.domain.model.PurchaseList
import com.gontharuk.wperdenazakupy.domain.repository.PurchaseListRepository
import javax.inject.Inject

class PurchaseListRepositoryImpl @Inject constructor(
    private val dao: PurchaseListDao
) : PurchaseListRepository {

    override suspend fun put(vararg purchaseList: PurchaseList) {
        purchaseList.map { it.toEntity() }
            .toTypedArray()
            .also { dao.put(*it) }
    }

    override suspend fun getAll(): List<PurchaseList> {
        return dao.getAll()
            .map { it.toModel() }
    }

    override suspend fun getAllKey(key: String): List<PurchaseList> {
        return dao.getAllKey(key)
            .map { it.toModel() }
    }

    override suspend fun delete(purchaseList: PurchaseList) {
        TODO("Not yet implemented")
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }
}