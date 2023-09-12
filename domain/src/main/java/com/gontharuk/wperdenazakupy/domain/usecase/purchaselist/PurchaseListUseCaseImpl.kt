package com.gontharuk.wperdenazakupy.domain.usecase.purchaselist

import com.gontharuk.wperdenazakupy.domain.model.PurchaseList
import com.gontharuk.wperdenazakupy.domain.repository.PurchaseListRepository
import javax.inject.Inject

class PurchaseListUseCaseImpl @Inject constructor(
    private val purchaseListRepository: PurchaseListRepository
) : PurchaseListUseCase {

    override suspend fun put(vararg purchaseList: PurchaseList) {
        purchaseListRepository.put(*purchaseList)
    }

    override suspend fun getAllKey(key: String): List<PurchaseList> {
        return purchaseListRepository.getAllKey(key)
    }

    override suspend fun getAll(): List<PurchaseList> {
        return purchaseListRepository.getAll()
    }
}