package com.gontharuk.wperdenazakupy.data.product.data.prefs

import android.content.SharedPreferences
import com.gontharuk.core.data.Mapper
import com.gontharuk.wperdenazakupy.data.product.domain.ProductRepository
import com.gontharuk.wperdenazakupy.data.product.entity.CategoryJsonMapper
import com.gontharuk.wperdenazakupy.data.product.entity.Product
import com.gontharuk.wperdenazakupy.data.product.entity.ProductJsonMapper
import com.gontharuk.wperdenazakupy.sahredprefs.PrefProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject

class ProductRepositoryImpl(
    private val mapper: Mapper<Product, JSONObject> = ProductJsonMapper(CategoryJsonMapper())
) : ProductRepository {

    //TODO DI
    private val prefs: SharedPreferences = PrefProvider.get(PrefProvider.Store.PRODUCT)

    override fun put(vararg product: Product): Flow<Unit> = flow {
        prefs.edit()
            .apply {
                product.iterator().forEach { next ->
                    putString(
                        product.hashCode().toString(),
                        mapper.mapA(next).getOrThrow().toString()
                    )
                }
            }.apply()
        emit(Unit)
    }

    override fun getAll(): Flow<List<Product>> = flow {
        prefs.all
            .map {
                mapper.mapB(JSONObject(it.value as String)).getOrThrow()
            }.also {
                emit(it)
            }
    }
}