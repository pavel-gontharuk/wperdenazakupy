package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.lifecycle.ViewModel
import com.gontharuk.wperdenazakupy.domain.usecase.product.ProductUseCase
import com.gontharuk.wperdenazakupy.presentation.core.tools.log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productUseCase: ProductUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<ProductListState> = MutableStateFlow(ProductListState())
    val state: StateFlow<ProductListState> get() = _state

    suspend fun fetch() {
        val list = withContext(Dispatchers.IO) {
            productUseCase
                .products()
                .map { it.toForm() }
        }
        _state.value = state.value.copy(list = list)
    }

    fun clicked(item: ProductListItemModel) {
        item.log()
        val list = state.value.list
        val index = list.indexOf(item).also { if (it < 0) return }
        list.toMutableList()
            .also {
                it[index] = item.copy(
                    expanded = !item.expanded
                ).log()
            }.also { result ->
                _state.value = state.value.copy(
                    list = result
                )
            }
    }
}