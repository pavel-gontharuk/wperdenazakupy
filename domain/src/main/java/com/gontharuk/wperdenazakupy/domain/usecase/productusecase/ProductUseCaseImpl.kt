package com.gontharuk.wperdenazakupy.domain.usecase.productusecase

import com.gontharuk.wperdenazakupy.domain.model.Product
import com.gontharuk.wperdenazakupy.domain.repository.ProductRepository
import javax.inject.Inject

class ProductUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : ProductUseCase {

    override suspend fun put(vararg product: Product) {
        productRepository.put(*product)
    }

    override suspend fun getAll(): List<Product> {
        return productRepository.getAll()
    }
}