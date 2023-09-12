package com.gontharuk.wperdenazakupy.data.database.purchaselist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "purchaseList")
data class PurchaseListEntity(

    @ColumnInfo(name = "name")
    @PrimaryKey val name: String,
    val list: List<String>
)
