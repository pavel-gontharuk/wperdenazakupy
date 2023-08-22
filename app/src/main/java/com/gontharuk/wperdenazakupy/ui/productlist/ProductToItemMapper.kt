package com.gontharuk.wperdenazakupy.ui.productlist

import com.gontharuk.wperdenazakupy.model.core.Mapper
import com.gontharuk.wperdenazakupy.model.product.entity.Product

class ProductToItemMapper : Mapper<Product, ProductListItemForm> {

    override fun map(data: Product): ProductListItemForm {
        return ProductListItemForm(
            name = data.name,
            description = data.description,
            category = data.category.name,
        )
    }
}