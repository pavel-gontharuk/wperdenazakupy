package com.gontharuk.wperdenazakupy.presentation.features.editcategory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gontharuk.wperdenazakupy.domain.usecase.category.CategoryUseCase
import com.gontharuk.wperdenazakupy.domain.usecase.product.ProductUseCase
import com.gontharuk.wperdenazakupy.presentation.features.editcategory.entity.EditCategoryItemModel
import com.gontharuk.wperdenazakupy.presentation.features.editcategory.entity.EditCategoryState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class EditCategoryViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase,
    private val productUseCase: ProductUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<EditCategoryState> = MutableStateFlow(EditCategoryState.Loading)
    val state: StateFlow<EditCategoryState> = _state

    suspend fun fetch(categoryId: Int) {
        val categoryJob = viewModelScope.async(Dispatchers.IO) {
            categoryUseCase.getById(categoryId)
        }
        val productsJob = viewModelScope.async(Dispatchers.IO) {
            productUseCase.products()
        }
        val category = categoryJob.await()
        val products = productsJob.await()
        _state.value = EditCategoryState.Edit(
            category = category,
            products = products,
            selectedIds = products.filter { it.id == categoryId }
                .map { it.id }
        )
    }

    fun itemClicked(item: EditCategoryItemModel) {
        val mState = state.value as? EditCategoryState.Edit ?: return
        _state.value = mState.copy(
            selectedIds = mState.selectedIds
                .toMutableList()
                .also { selected ->
                    if (item.selected) selected.remove(item.id)
                    else selected.add(item.id)
                }
        )
    }

    fun onName(name: String) {
        val mState = state.value as? EditCategoryState.Edit ?: return
        _state.value = mState.copy(
            category = mState.category.copy(
                name = name
            )
        )
    }

    fun save() {
        TODO()
    }
}