package com.gontharuk.wperdenazakupy.data.database.product

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product")
data class ProductEntity(
    @PrimaryKey val name: String,
    val description: String,
)
