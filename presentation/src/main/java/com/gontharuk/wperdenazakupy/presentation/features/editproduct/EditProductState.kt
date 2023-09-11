package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import com.gontharuk.wperdenazakupy.domain.model.Product

data class EditProductState(
    val name: String = "",
    val description: String = "",
)

fun EditProductState.toProduct(): Product = Product(
    name = name,
    description = description,
)