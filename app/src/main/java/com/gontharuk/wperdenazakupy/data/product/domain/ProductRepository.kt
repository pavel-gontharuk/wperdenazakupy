package com.gontharuk.wperdenazakupy.data.product.domain

import com.gontharuk.wperdenazakupy.data.product.entity.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun put(product: Product): Flow<Unit>

    fun getAll(): Flow<List<Product>>
}