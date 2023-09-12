package com.gontharuk.wperdenazakupy.domain.repository

import com.gontharuk.wperdenazakupy.domain.model.PurchaseList

interface PurchaseListRepository {

    suspend fun put(vararg purchaseList: PurchaseList)

    suspend fun getAll(): List<PurchaseList>

    suspend fun getAllKey(key: String): List<PurchaseList>

    suspend fun delete(purchaseList: PurchaseList)

    suspend fun clear()
}