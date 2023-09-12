package com.gontharuk.wperdenazakupy.domain.usecase.product

import com.gontharuk.wperdenazakupy.domain.model.Product
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import javax.inject.Inject

class ProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : ProductUseCase {

    override suspend fun putProduct(vararg product: Product) {
        productRepository.put(*product)
    }

    override suspend fun products(): List<Product> {
        return productRepository.getAll()
    }
}