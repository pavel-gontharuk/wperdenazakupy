package com.gontharuk.wperdenazakupy.data.database.converters

import androidx.room.TypeConverter
import org.json.JSONArray

class ListConverter {

    @TypeConverter
    fun toList(input: String?): List<Int>? {
        input ?: return null
        return ArrayList<Int>().also { list ->
            JSONArray(input).also {
                for (index in 0 until it.length()) {
                    list.add(it.getInt(index))
                }
            }
        }
    }

    @TypeConverter
    fun fromList(list: List<Int>?): String? {
        list ?: return null
        return JSONArray().also { json ->
            list.forEach { json.put(it) }
        }.toString()
    }
}