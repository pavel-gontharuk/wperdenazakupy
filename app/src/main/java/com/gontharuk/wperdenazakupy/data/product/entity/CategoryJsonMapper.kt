package com.gontharuk.wperdenazakupy.data.product.entity

import com.gontharuk.core.data.JsonMapper
import org.json.JSONObject

class CategoryJsonMapper : JsonMapper<Category>() {

    override fun toJson(data: Category): JSONObject = JSONObject().apply {
        put(Category::title.name, data.title)
    }

    override fun fromJson(json: JSONObject): Category = Category(
        title = json.getString(Category::title.name)
    )
}