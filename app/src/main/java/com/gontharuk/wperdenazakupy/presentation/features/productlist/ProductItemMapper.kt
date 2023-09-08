package com.gontharuk.wperdenazakupy.presentation.features.productlist

import com.gontharuk.core.data.Mapper
import com.gontharuk.wperdenazakupy.data.product.entity.Category
import com.gontharuk.wperdenazakupy.data.product.entity.Product
import com.gontharuk.wperdenazakupy.utils.asSuccess

class ProductItemMapper : Mapper<Product, ProductListItemForm> {

    override fun mapA(input: Product): Result<ProductListItemForm> = ProductListItemForm(
        title = input.title,
        description = input.description,
        category = input.category.title,
    ).asSuccess()


    override fun mapB(input: ProductListItemForm): Result<Product> = Product(
        title = input.title,
        description = input.description,
        category = Category(input.category),
    ).asSuccess()
}