package com.gontharuk.wperdenazakupy.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.gontharuk.wperdenazakupy.data.database.bucket.BucketDao
import com.gontharuk.wperdenazakupy.data.database.bucket.BucketEntity
import com.gontharuk.wperdenazakupy.data.database.category.CategoryDao
import com.gontharuk.wperdenazakupy.data.database.converters.SetConverter
import com.gontharuk.wperdenazakupy.data.database.product.ProductDao
import com.gontharuk.wperdenazakupy.data.database.product.ProductEntity

@Database(
    entities = [ProductEntity::class, BucketEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(SetConverter::class)
abstract class WperdeDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao

    abstract fun bucketDao(): BucketDao

    abstract fun categoryDao(): CategoryDao
}