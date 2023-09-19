package com.gontharuk.wperdenazakupy.domain.usecase.category

import com.gontharuk.wperdenazakupy.domain.core.generateId
import com.gontharuk.wperdenazakupy.domain.model.Category
import com.gontharuk.wperdenazakupy.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : CategoryUseCase {

    override suspend fun put(vararg category: Category) {
        category.map { createCategory(it) }
            .toTypedArray()
            .also { categoryRepository.put(*it) }

    }

    override suspend fun getAll(): List<Category> {
        return categoryRepository.getAll()
    }

    override suspend fun getById(id: Int): Category {
        return categoryRepository.getById(id).firstOrNull() ?: Category()
    }

    private fun createCategory(category: Category): Category {
        if (category.isDefault) return category
        val creation = if (category.creation > 0) category.creation
        else System.currentTimeMillis()
        val id = if (category.id > 0) category.id
        else generateId(category.name, creation)
        return category.copy(
            id = id,
            creation = creation
        )
    }
}