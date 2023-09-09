package com.gontharuk.wperdenazakupy.presentation.features.productlist

import com.gontharuk.wperdenazakupy.domain.model.Product

data class ProductListItemForm(
    val title: String,
    val description: String
) {
    constructor(product: Product) : this(
        title = product.name,
        description = product.description,
    )
}