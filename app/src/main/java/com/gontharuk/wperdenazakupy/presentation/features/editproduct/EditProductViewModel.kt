package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.lifecycle.viewModelScope
import com.gontharuk.wperdenazakupy.domain.usecase.ProductUseCase
import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.WperdeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EditProductViewModel @Inject constructor(
    private val productUseCase: ProductUseCase
) : WperdeViewModel<EditProductState>(EditProductState()) {

    fun onName(name: String) {
        updateState { it.copy(name = name) }
    }

    fun onDescription(description: String) {
        updateState { it.copy(description = description) }
    }

    fun save() {
        viewModelScope.launch {

            withContext(Dispatchers.IO) {
                state().copy()
                    .toProduct()
                    .also { productUseCase.put(it) }
            }

            updateState {
                it.copy(
                    name = "",
                    description = "",
                )
            }
        }
    }
}