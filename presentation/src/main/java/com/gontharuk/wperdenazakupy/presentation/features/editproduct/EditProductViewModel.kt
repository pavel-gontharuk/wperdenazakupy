package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gontharuk.wperdenazakupy.domain.usecase.product.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EditProductViewModel @Inject constructor(
    private val productUseCase: ProductUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<EditProductState> = MutableStateFlow(EditProductState())
    val state: StateFlow<EditProductState> get() = _state

    fun onName(name: String) {
        _state.value = state.value.copy(name = name)
    }

    fun onDescription(description: String) {
        _state.value = state.value.copy(description = description)
    }

    fun save() {
        viewModelScope.launch {

            withContext(Dispatchers.IO) {
                state.value.copy()
                    .toProduct()
                    .also { productUseCase.putProduct(it) }
            }
            _state.value = state.value.copy(
                name = "",
                description = "",
            )
        }
    }
}