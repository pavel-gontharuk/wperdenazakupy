package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.lifecycle.ViewModel
import com.gontharuk.wperdenazakupy.domain.usecase.productusecase.ProductUseCase
import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.HasState
import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.StateHolder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val productUseCase: ProductUseCase,
    private val stateHolder: StateHolder<ProductListState>
) : ViewModel(), HasState<ProductListState> {

    override val state: StateFlow<ProductListState> get() = stateHolder.state

    suspend fun fetch() {
        val list = withContext(Dispatchers.IO) {
            productUseCase
                .getAll()
                .map { it.toForm() }
        }

        stateHolder.updateState { it.copy(list = list) }
    }
}