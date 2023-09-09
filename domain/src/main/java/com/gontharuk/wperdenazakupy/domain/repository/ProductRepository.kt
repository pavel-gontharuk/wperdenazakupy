package com.gontharuk.wperdenazakupy.domain.repository

import com.gontharuk.wperdenazakupy.domain.model.Product

interface ProductRepository {

    suspend fun put(vararg product: Product)

    suspend fun get(key: String): Product

    suspend fun getAll(): List<Product>

    suspend fun delete(key: String)

    suspend fun delete(product: Product)

    suspend fun clear()
}