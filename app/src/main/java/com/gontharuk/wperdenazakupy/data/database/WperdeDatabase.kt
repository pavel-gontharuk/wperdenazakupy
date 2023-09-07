package com.gontharuk.wperdenazakupy.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gontharuk.wperdenazakupy.data.product.entity.Category
import com.gontharuk.wperdenazakupy.data.product.entity.Product

@Database(entities = [Product::class, Category::class], version = 1)
abstract class WperdeDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    abstract fun categoryDao(): CategoryDao
}