package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.lifecycle.viewModelScope
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCase
import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.WperdeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productUseCase: ProductUseCase
) : WperdeViewModel<ProductListState>(ProductListState()) {

    fun fetch() {
        viewModelScope.launch {
            val list = withContext(Dispatchers.IO) {
                productUseCase
                    .getAll()
                    .map { ProductListItemForm(it) }
            }

            updateState { it.copy(list = list) }
        }
    }
}