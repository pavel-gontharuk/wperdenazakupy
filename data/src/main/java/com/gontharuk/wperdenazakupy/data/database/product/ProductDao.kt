package com.gontharuk.wperdenazakupy.data.database.product

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun put(vararg productEntity: ProductEntity)

    @Query("SELECT * FROM product")
    fun getAll(): List<ProductEntity>
}