package com.gontharuk.wperdenazakupy.data.product.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Category(
    val title: String = DEFAULT_CATEGORY,
) : Parcelable {

    companion object {
        const val DEFAULT_CATEGORY = "default_category"
    }
}
