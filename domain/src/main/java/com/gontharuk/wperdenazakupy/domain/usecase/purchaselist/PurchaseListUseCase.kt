package com.gontharuk.wperdenazakupy.domain.usecase.purchaselist

import com.gontharuk.wperdenazakupy.domain.model.PurchaseList

interface PurchaseListUseCase {

    suspend fun put(vararg purchaseList: PurchaseList)

    suspend fun getAll(): List<PurchaseList>

    suspend fun getAllKey(key: String): List<PurchaseList>
}