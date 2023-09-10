package com.gontharuk.wperdenazakupy.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gontharuk.wperdenazakupy.data.database.product.ProductDao
import com.gontharuk.wperdenazakupy.data.database.product.ProductEntity

@Database(entities = [ProductEntity::class], version = 1, exportSchema = false)
abstract class WperdeDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}