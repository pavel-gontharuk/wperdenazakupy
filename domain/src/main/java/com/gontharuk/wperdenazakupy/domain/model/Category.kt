package com.gontharuk.wperdenazakupy.domain.model

data class Category(
    val id: Int = -1,
    val creation: Long = -1,
    val name: String = defaultName
){
    companion object{
        private const val defaultName = "defaultName"
    }

    val isDefault: Boolean get() = (name == defaultName)
}