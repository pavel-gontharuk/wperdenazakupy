package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import com.gontharuk.wperdenazakupy.domain.model.Product
import com.gontharuk.wperdenazakupy.presentation.core.data.generateId

data class EditProductState(
    val name: String = "",
    val description: String = "",
)

fun EditProductState.toProduct(): Product = this.let {
    val created = System.currentTimeMillis()
    Product(
        id = generateId(name),
        creation = created,
        name = name,
        description = description,
    )
}