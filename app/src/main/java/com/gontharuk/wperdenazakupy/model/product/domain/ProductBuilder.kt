package com.gontharuk.wperdenazakupy.model.product.domain

import com.gontharuk.wperdenazakupy.model.product.entity.Product

interface ProductBuilder {

    fun name(name: String): ProductBuilder

    fun description(description: String): ProductBuilder

    fun category(category: String): ProductBuilder

    fun build(): Result<Product>
}