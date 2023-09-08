package com.gontharuk.wperdenazakupy.data.database

import com.gontharuk.wperdenazakupy.data.product.domain.ProductRepository
import com.gontharuk.wperdenazakupy.data.product.entity.Product
import com.gontharuk.wperdenazakupy.presentation.WperdeApplication
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepositoryImpl : ProductRepository {

    private val dao: ProductDao = WperdeApplication.database.productDao()

    override fun getAll(): Flow<List<Product>> {
        return flowOf(dao.getAll())
    }

    override fun put(vararg product: Product): Flow<Unit> {
        return flowOf(dao.put(*product))
    }
}