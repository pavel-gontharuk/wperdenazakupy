package com.gontharuk.wperdenazakupy.data.product.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "category")
@Parcelize
data class Category(
    @PrimaryKey val title: String = DEFAULT_CATEGORY,
) : Parcelable {

    companion object {
        const val DEFAULT_CATEGORY = "default_category"
    }
}
