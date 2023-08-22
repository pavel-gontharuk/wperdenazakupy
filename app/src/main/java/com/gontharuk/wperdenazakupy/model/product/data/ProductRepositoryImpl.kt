package com.gontharuk.wperdenazakupy.model.product.data

import com.gontharuk.wperdenazakupy.model.core.Store
import com.gontharuk.wperdenazakupy.model.product.domain.ProductRepository
import com.gontharuk.wperdenazakupy.model.product.entity.Product
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl : ProductRepository {

    private val store: Store<String, Product>

    init {
        // TODO Implement DI
        store = ProductStore
    }

    override fun put(product: Product): Flow<Result<Unit>> {
        return store.put(product.name, product)
    }

    override fun getAll(): Flow<Result<List<Product>>> {
        return store.getAll()
    }
}