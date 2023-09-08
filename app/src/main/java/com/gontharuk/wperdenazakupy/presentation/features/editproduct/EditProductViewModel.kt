package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.lifecycle.viewModelScope
import com.gontharuk.wperdenazakupy.data.database.ProductRepositoryImpl
import com.gontharuk.wperdenazakupy.data.product.data.ProductBuilderImpl
import com.gontharuk.wperdenazakupy.data.product.domain.ProductBuilder
import com.gontharuk.wperdenazakupy.data.product.domain.ProductRepository
import com.gontharuk.wperdenazakupy.data.product.entity.Product
import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.WperdeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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

            withContext(Dispatchers.IO){
                productRepository
                    .put(product)
                    .collect()
            }

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