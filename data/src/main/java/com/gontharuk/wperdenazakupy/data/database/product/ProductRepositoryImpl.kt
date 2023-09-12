package com.gontharuk.wperdenazakupy.data.database.product

import com.gontharuk.wperdenazakupy.domain.model.Product
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDao: ProductDao
) : ProductRepository {

    override suspend fun put(vararg product: Product) {
        product.map { it.toEntity() }
            .toTypedArray()
            .also { productDao.put(*it) }
    }

    override suspend fun get(key: String): Product {
        TODO("Not yet implemented")
    }

    override suspend fun getAll(): List<Product> {
        return productDao.getAll()
            .map { it.toModel() }
    }

    override suspend fun delete(key: String) {
        TODO("Not yet implemented")
    }

    override suspend fun delete(product: Product) {
        TODO("Not yet implemented")
    }

    override suspend fun clear() {
        TODO("Not yet implemented")
    }
}