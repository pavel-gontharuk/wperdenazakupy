package com.gontharuk.wperdenazakupy.data.database.converters

import androidx.room.TypeConverter
import dagger.internal.SetBuilder
import org.json.JSONArray

class SetConverter {

    @TypeConverter
    fun toSet(input: String?): Set<Int>? {
        input ?: return null
        val json = JSONArray(input)
        return SetBuilder.newSetBuilder<Int>(json.length()).also { set ->
            for (index in 0 until json.length()) {
                set.add(json.getInt(index))
            }
        }.build()
    }

    @TypeConverter
    fun formSet(set: Set<Int>?): String? {
        set ?: return null
        return JSONArray().also { json ->
            set.forEach { json.put(it) }
        }.toString()
    }
}