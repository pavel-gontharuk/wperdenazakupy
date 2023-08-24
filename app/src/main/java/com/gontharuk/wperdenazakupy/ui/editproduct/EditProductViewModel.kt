package com.gontharuk.wperdenazakupy.ui.editproduct

import androidx.lifecycle.viewModelScope
import com.gontharuk.wperdenazakupy.data.product.data.ProductBuilderImpl
import com.gontharuk.wperdenazakupy.data.product.data.prefs.ProductRepositoryImpl
import com.gontharuk.wperdenazakupy.data.product.domain.ProductBuilder
import com.gontharuk.wperdenazakupy.data.product.domain.ProductRepository
import com.gontharuk.wperdenazakupy.data.product.entity.Product
import com.gontharuk.wperdenazakupy.ui.core.viewmodel.WperdeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class EditProductViewModel(
    form: EditProductState
) : WperdeViewModel<EditProductState>(form) {

    private val productRepository: ProductRepository
    private val productBuilder: ProductBuilder

    init {
        // TODO Implement DI
        productRepository = ProductRepositoryImpl()
        productBuilder = ProductBuilderImpl()
    }

    fun onName(name: String) {
        updateState(state().copy(name = name))
    }

    fun onCategory(category: String) {
        updateState(state().copy(category = category))
    }

    fun onDescription(description: String) {
        updateState(state().copy(description = description))
    }

    fun save() {
        viewModelScope.launch {

            val state = state().copy()

            val product: Product = productBuilder
                .name(state.name)
                .description(state.description)
                .category(state.category)
                .build()
                .getOrElse { return@launch }

            productRepository
                .put(product)
                .collect()

            updateState(
                state().copy(
                    name = "",
                    description = "",
                    category = "",
                )
            )
        }
    }
}