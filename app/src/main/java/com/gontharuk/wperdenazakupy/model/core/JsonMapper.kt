package com.gontharuk.wperdenazakupy.model.core

import org.json.JSONObject

abstract class JsonMapper<T> : Mapper<T, JSONObject> {

    protected abstract fun toJson(data: T): JSONObject

    protected abstract fun fromJson(json: JSONObject): T

    override fun mapA(input: T): Result<JSONObject> = try {
        Result.success(toJson(input))
    } catch (ex: Exception) {
        Result.failure(ex)
    }

    override fun mapB(input: JSONObject): Result<T> = try {
        Result.success(fromJson(input))
    } catch (ex: Exception) {
        Result.failure(ex)
    }
}