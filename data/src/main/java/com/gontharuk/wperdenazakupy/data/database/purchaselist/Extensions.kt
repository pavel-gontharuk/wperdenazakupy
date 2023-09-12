package com.gontharuk.wperdenazakupy.data.database.purchaselist

import com.gontharuk.wperdenazakupy.domain.model.PurchaseList

fun PurchaseList.toEntity(): PurchaseListEntity = PurchaseListEntity(
    name = this.name,
    list = this.list
)

fun PurchaseListEntity.toModel(): PurchaseList = PurchaseList(
    name = this.name,
    list = this.list
)