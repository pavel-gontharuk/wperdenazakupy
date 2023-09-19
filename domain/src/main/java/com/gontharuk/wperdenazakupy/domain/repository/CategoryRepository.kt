package com.gontharuk.wperdenazakupy.domain.repository

import com.gontharuk.wperdenazakupy.domain.model.Category

interface CategoryRepository {

    suspend fun put(vararg category: Category)

    suspend fun getAll(): List<Category>

    suspend fun getById(id: Int): List<Category>
}