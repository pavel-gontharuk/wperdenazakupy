package com.gontharuk.wperdenazakupy.data.product.entity

import androidx.room.TypeConverter

class CategoryConverter {

    @TypeConverter
    fun fromString(value: String?): Category {
        return value?.let { Category(it) } ?: Category()
    }

    @TypeConverter
    fun toString(value: Category?): String {
        return (value ?: Category()).title
    }
}