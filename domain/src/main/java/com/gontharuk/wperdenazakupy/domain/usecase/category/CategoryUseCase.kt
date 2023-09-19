package com.gontharuk.wperdenazakupy.domain.usecase.category

import com.gontharuk.wperdenazakupy.domain.model.Category

interface CategoryUseCase {

    suspend fun put(vararg category: Category)

    suspend fun getAll(): List<Category>

    suspend fun getById(id: Int): Category
}