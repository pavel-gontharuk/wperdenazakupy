package com.gontharuk.wperdenazakupy.data.database.category

import com.gontharuk.wperdenazakupy.domain.model.Category

fun Category.toEntity(): CategoryEntity = CategoryEntity(
    id = id,
    creation = creation,
    name = name
)

fun CategoryEntity.toModel(): Category = Category(
    id = id,
    creation = creation,
    name = name
)