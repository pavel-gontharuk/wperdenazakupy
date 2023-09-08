package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.lifecycle.viewModelScope
import com.gontharuk.core.data.Mapper
import com.gontharuk.wperdenazakupy.data.database.ProductRepositoryImpl
import com.gontharuk.wperdenazakupy.data.product.domain.ProductRepository
import com.gontharuk.wperdenazakupy.data.product.entity.Product
import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.WperdeViewModel
import kotlinx.coroutines.CompletableDeferred
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
                val deferred = CompletableDeferred<List<Product>>()
                productRepository
                    .getAll()
                    .collect { deferred.complete(it) }
                deferred.await()
                    .map { productMapper.mapA(it) }
                    .map { it.getOrThrow() }
            }

            updateState(state().copy(list = list))
        }
    }
}