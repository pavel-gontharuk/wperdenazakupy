package com.gontharuk.wperdenazakupy.domain.model

data class Bucket(
    val id: Int = -1,
    val name: String,
    val list: List<Int> = emptyList()
)
