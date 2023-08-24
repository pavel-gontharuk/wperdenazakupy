package com.gontharuk.wperdenazakupy.ui.productlist

import com.gontharuk.wperdenazakupy.model.core.Mapper
import com.gontharuk.wperdenazakupy.model.product.entity.Category
import com.gontharuk.wperdenazakupy.model.product.entity.Product
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