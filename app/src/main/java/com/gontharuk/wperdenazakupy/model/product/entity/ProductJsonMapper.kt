package com.gontharuk.wperdenazakupy.model.product.entity

import com.gontharuk.wperdenazakupy.model.core.JsonMapper
import org.json.JSONObject

class ProductJsonMapper(
    private val categoryMapper: JsonMapper<Category>,
) : JsonMapper<Product>() {

    override fun toJson(data: Product): JSONObject = JSONObject().apply {
        put(Product::title.name, data.title)
        put(Product::description.name, data.description)
        put(Product::category.name, categoryMapper.mapA(data.category).getOrThrow())
    }

    override fun fromJson(json: JSONObject): Product = Product(
        title = json.getString(Product::title.name),
        description = json.getString(Product::description.name),
        category = categoryMapper.mapB(json.getJSONObject(Product::category.name)).getOrThrow(),
    )
}