package com.gontharuk.wperdenazakupy.data.product.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val title: String,
    val description: String,
    val category: Category
) : Parcelable
