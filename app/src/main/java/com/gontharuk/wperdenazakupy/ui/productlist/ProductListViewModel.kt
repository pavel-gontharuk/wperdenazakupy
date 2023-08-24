package com.gontharuk.wperdenazakupy.ui.productlist

import androidx.lifecycle.viewModelScope
import com.gontharuk.wperdenazakupy.model.core.Mapper
import com.gontharuk.wperdenazakupy.model.coroutines.collectDeferred
import com.gontharuk.wperdenazakupy.model.product.data.prefs.ProductRepositoryImpl
import com.gontharuk.wperdenazakupy.model.product.domain.ProductRepository
import com.gontharuk.wperdenazakupy.model.product.entity.Product
import com.gontharuk.wperdenazakupy.ui.core.viewmodel.WperdeViewModel
import kotlinx.coroutines.launch

class ProductListViewModel(
    form: ProductListState
) : WperdeViewModel<ProductListState>(form) {

    private val productRepository: ProductRepository
    private val productMapper: Mapper<Product, ProductListItemForm>

    init {
        // TODO Implement DI
        productRepository = ProductRepositoryImpl()
        productMapper = ProductItemMapper()
    }

    fun fetch() {
        viewModelScope.launch {
            val list = productRepository
                .getAll()
                .collectDeferred()
                .map { productMapper.mapA(it) }
                .map { it.getOrThrow() }

            updateState(state().copy(list = list))
        }
    }
}