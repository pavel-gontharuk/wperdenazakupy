package com.gontharuk.wperdenazakupy.domain.usecase.product

import com.gontharuk.wperdenazakupy.domain.model.Product

interface ProductUseCase {

    suspend fun putProduct(vararg product: Product)

    suspend fun products(): List<Product>
}