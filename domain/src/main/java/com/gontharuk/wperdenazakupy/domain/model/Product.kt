package com.gontharuk.wperdenazakupy.domain.model

data class Product(
    val id: Int = -1,
    val creation: Long = -1,
    val name: String,
    val description: String
)