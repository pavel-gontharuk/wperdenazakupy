package com.gontharuk.wperdenazakupy.data.database.category

import com.gontharuk.wperdenazakupy.domain.model.Category
import com.gontharuk.wperdenazakupy.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val dao: CategoryDao
) : CategoryRepository {

    override suspend fun put(vararg category: Category) {
        category.map { it.toEntity() }
            .toTypedArray()
            .also { dao.put(*it) }
    }

    override suspend fun getAll(): List<Category> {
        return dao.getAll()
            .map { it.toModel() }
    }

    override suspend fun getById(id: Int): List<Category> {
        return dao.getById(id)
    }
}