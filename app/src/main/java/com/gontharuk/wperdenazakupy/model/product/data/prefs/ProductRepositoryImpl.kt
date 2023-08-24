package com.gontharuk.wperdenazakupy.model.product.data.prefs

import android.content.SharedPreferences
import com.gontharuk.wperdenazakupy.model.core.Mapper
import com.gontharuk.wperdenazakupy.model.product.domain.ProductRepository
import com.gontharuk.wperdenazakupy.model.product.entity.CategoryJsonMapper
import com.gontharuk.wperdenazakupy.model.product.entity.Product
import com.gontharuk.wperdenazakupy.model.product.entity.ProductJsonMapper
import com.gontharuk.wperdenazakupy.sahredprefs.PrefProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject

class ProductRepositoryImpl(
    private val mapper: Mapper<Product, JSONObject> = ProductJsonMapper(CategoryJsonMapper())
) : ProductRepository {

    //TODO DI
    private val prefs: SharedPreferences = PrefProvider.get(PrefProvider.Store.PRODUCT)

    override fun put(product: Product): Flow<Unit> = flow {
        prefs.edit()
            .putString(
                product.hashCode().toString(),
                mapper.mapA(product).getOrThrow().toString()
            ).apply()
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