package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import com.gontharuk.wperdenazakupy.domain.model.Product

fun EditProductState.toProduct(): Product = Product(
    name = name,
    description = description,
)
