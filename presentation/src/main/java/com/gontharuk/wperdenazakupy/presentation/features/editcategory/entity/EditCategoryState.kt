package com.gontharuk.wperdenazakupy.presentation.features.editcategory.entity

import com.gontharuk.wperdenazakupy.domain.model.Category
import com.gontharuk.wperdenazakupy.domain.model.Product

sealed class EditCategoryState {

    data object Loading : EditCategoryState()

    data class Edit(
        val category: Category,
        val products: List<Product>,
        val selectedIds: List<Int>
    ) : EditCategoryState() {
        val name: String = category.name
        val itemList: List<EditCategoryItemModel> = products.map {
            EditCategoryItemModel(
                id = it.id,
                name = it.name,
                selected = selectedIds.contains(it.id)
            )
        }
    }
}
