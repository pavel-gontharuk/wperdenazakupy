package com.gontharuk.wperdenazakupy.data.product.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "product")
@Parcelize
data class Product(
    @PrimaryKey val title: String,
    val description: String,
    val category: Category,
) : Parcelable