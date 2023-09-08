package com.gontharuk.wperdenazakupy.data.database

import com.gontharuk.wperdenazakupy.data.product.domain.CategoryRepository
import com.gontharuk.wperdenazakupy.data.product.entity.Category
import com.gontharuk.wperdenazakupy.presentation.WperdeApplication
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class CategoryRepositoryImpl : CategoryRepository {

    private val dao: CategoryDao = WperdeApplication.database.categoryDao()

    override fun getAll(): Flow<List<Category>> = flow {
        dao.getAll()
    }

    override fun put(vararg category: Category): Flow<Unit> = flow {
        dao.put(*category)
    }
}