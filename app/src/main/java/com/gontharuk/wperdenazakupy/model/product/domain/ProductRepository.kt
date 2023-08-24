package com.gontharuk.wperdenazakupy.model.product.domain

import com.gontharuk.wperdenazakupy.model.product.entity.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun put(product: Product): Flow<Unit>

    fun getAll(): Flow<List<Product>>
}