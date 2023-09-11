package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCase
import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.HasState
import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.StateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class EditProductViewModel @Inject constructor(
    private val productUseCase: ProductUseCase,
    private val stateHolder: StateHolder<EditProductState>
) : ViewModel(), HasState<EditProductState> {

    override val state: StateFlow<EditProductState> get() = stateHolder.state

    fun onName(name: String) {
        stateHolder.updateState { it.copy(name = name) }
    }

    fun onDescription(description: String) {
        stateHolder.updateState { it.copy(description = description) }
    }

    fun save() {
        viewModelScope.launch {

            withContext(Dispatchers.IO) {
                stateHolder.state.value.copy()
                    .toProduct()
                    .also { productUseCase.put(it) }
            }

            stateHolder.updateState {
                it.copy(
                    name = "",
                    description = "",
                )
            }
        }
    }
}