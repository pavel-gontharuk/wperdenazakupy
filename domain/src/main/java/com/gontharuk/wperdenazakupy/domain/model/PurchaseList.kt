package com.gontharuk.wperdenazakupy.domain.model

data class PurchaseList(
    val name: String,
    val list: List<String> = emptyList()
)
