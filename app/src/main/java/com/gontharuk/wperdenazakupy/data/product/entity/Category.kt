package com.gontharuk.wperdenazakupy.data.product.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val title: String
) : Parcelable {

    companion object {
        const val DEFAULT_CATEGORY = "default_category"
    }
}
