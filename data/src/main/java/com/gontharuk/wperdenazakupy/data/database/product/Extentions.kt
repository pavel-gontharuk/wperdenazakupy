package com.gontharuk.wperdenazakupy.data.database.product

import com.gontharuk.wperdenazakupy.domain.model.Product

fun Product.toEntity(): ProductEntity = ProductEntity(
    id = id,
    creation = creation,
    name = name,
    description = description
)

fun ProductEntity.toModel(): Product = Product(
    id = id,
    creation = creation,
    name = name,
    description = description
)