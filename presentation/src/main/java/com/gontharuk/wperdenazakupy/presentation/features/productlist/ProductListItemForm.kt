package com.gontharuk.wperdenazakupy.presentation.features.productlist

import com.gontharuk.wperdenazakupy.domain.model.Product

data class ProductListItemForm(
    val title: String,
    val description: String
)

fun Product.toForm(): ProductListItemForm = ProductListItemForm(
    title = this.name,
    description = this.description,
)