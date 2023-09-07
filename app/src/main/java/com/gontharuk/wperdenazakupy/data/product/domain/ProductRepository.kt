package com.gontharuk.wperdenazakupy.data.product.domain

import com.gontharuk.wperdenazakupy.data.product.entity.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    fun getAll(): Flow<List<Product>>

    fun put(vararg product: Product): Flow<Unit>
}