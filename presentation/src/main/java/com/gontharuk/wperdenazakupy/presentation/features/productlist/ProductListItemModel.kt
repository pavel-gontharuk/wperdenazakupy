package com.gontharuk.wperdenazakupy.presentation.features.productlist

import com.gontharuk.wperdenazakupy.domain.model.Product

data class ProductListItemModel(
    val title: String,
    val description: String,
    val expanded: Boolean = false
)

fun Product.toForm(): ProductListItemModel = ProductListItemModel(
    title = this.name,
    description = this.description,
)