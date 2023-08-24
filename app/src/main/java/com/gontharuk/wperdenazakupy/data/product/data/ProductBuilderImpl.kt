package com.gontharuk.wperdenazakupy.data.product.data

import com.gontharuk.wperdenazakupy.data.product.domain.ProductBuilder
import com.gontharuk.wperdenazakupy.data.product.entity.Category
import com.gontharuk.wperdenazakupy.data.product.entity.Category.Companion.DEFAULT_CATEGORY
import com.gontharuk.wperdenazakupy.data.product.entity.Product

class ProductBuilderImpl : ProductBuilder {

    private var _name: String? = null
    private var _description: String = ""
    private var _category: Category = Category(DEFAULT_CATEGORY)

    override fun name(name: String) = this.apply {
        _name = name
    }

    override fun description(description: String) = this.apply {
        _description = description
    }

    override fun category(category: String) = this.apply {
        if (category.isNotEmpty() and category.isNotBlank()) {
            _category = Category(category)
        }
    }

    override fun build(): Result<Product> {
        val result: Result<Product> = try {
            val product = Product(
                title = _name!!,
                description = _description,
                category = _category,
            )
            Result.success(product)
        } catch (ex: Exception) {
            Result.failure(ex)
        }
        return result
    }
}