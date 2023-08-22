package com.gontharuk.wperdenazakupy.model.product.entity

data class Category(
    val name: String
) {

    companion object {
        const val DEFAULT_CATEGORY = "default_category"
    }
}
