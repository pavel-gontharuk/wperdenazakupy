package com.gontharuk.wperdenazakupy.data.database.product

import com.gontharuk.wperdenazakupy.domain.model.Product

fun Product.toEntity(): ProductEntity = ProductEntity(
    name = this.name,
    description = this.description
)

fun ProductEntity.toModel(): Product = Product(
    name = this.name,
    description = this.description
)