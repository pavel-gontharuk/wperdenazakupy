package com.gontharuk.wperdenazakupy.domain.usecase

import com.gontharuk.wperdenazakupy.domain.model.Product

interface ProductUseCase {

    suspend fun put(vararg product: Product)

    suspend fun getAll(): List<Product>
}