package com.gontharuk.wperdenazakupy.ui.productlist

import androidx.lifecycle.viewModelScope
import com.gontharuk.core.data.Mapper
import com.gontharuk.wperdenazakupy.data.coroutines.collectDeferred
import com.gontharuk.wperdenazakupy.data.database.ProductRepositoryImpl
import com.gontharuk.wperdenazakupy.data.product.domain.ProductRepository
import com.gontharuk.wperdenazakupy.data.product.entity.Product
import com.gontharuk.wperdenazakupy.ui.core.viewmodel.WperdeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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
            val list = withContext(Dispatchers.IO) {
                productRepository
                    .getAll()
                    .collectDeferred()
                    .map { productMapper.mapA(it) }
                    .map { it.getOrThrow() }
            }

            updateState(state().copy(list = list))
        }
    }
}