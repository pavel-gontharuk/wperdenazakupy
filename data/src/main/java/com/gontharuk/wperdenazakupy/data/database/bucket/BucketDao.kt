package com.gontharuk.wperdenazakupy.data.database.bucket

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface BucketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun put(vararg purchaseList: BucketEntity)

    @Query("SELECT * FROM bucket")
    fun getAll(): List<BucketEntity>

    @Query("SELECT * FROM bucket WHERE name LIKE :key")
    fun getAllKey(key: String): List<BucketEntity>
}