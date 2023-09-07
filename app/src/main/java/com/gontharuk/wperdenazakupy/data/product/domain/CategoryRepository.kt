package com.gontharuk.wperdenazakupy.data.product.domain

import com.gontharuk.wperdenazakupy.data.product.entity.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {

    fun getAll(): Flow<List<Category>>

    fun put(vararg category: Category): Flow<Unit>
}