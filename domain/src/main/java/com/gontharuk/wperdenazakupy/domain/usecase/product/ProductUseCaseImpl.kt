package com.gontharuk.wperdenazakupy.domain.usecase.product

import com.gontharuk.wperdenazakupy.domain.core.generateId
import com.gontharuk.wperdenazakupy.domain.model.Product
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import javax.inject.Inject

class ProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : ProductUseCase {

    override suspend fun putProduct(vararg product: Product) {
        product.map { createProduct(it) }
            .toTypedArray()
            .also {
                productRepository.put(*it)
            }
    }

    override suspend fun products(): List<Product> {
        return productRepository.getAll()
    }

    private fun createProduct(product: Product): Product {
        val creation: Long = if (product.creation > 0) product.creation
        else System.currentTimeMillis()
        val id: Int = if (product.id > 0) product.id
        else generateId(product.name, creation)
        return product.copy(
            id = id,
            creation = creation
        )
    }
}