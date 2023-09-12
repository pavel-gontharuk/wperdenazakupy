package com.gontharuk.wperdenazakupy.data.database.purchaselist

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PurchaseListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun put(vararg purchaseList: PurchaseListEntity)

    @Query("SELECT * FROM purchaseList")
    fun getAll(): List<PurchaseListEntity>

    @Query("SELECT * FROM purchaseList WHERE name LIKE :key")
    fun getAllKey(key: String): List<PurchaseListEntity>
}