package com.gontharuk.wperdenazakupy.data.product.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.parcelize.Parcelize

@Entity(tableName = "product")
@TypeConverters()
@Parcelize
data class Product(
    @PrimaryKey val title: String,
    val description: String,
    val category: Category,
) : Parcelable