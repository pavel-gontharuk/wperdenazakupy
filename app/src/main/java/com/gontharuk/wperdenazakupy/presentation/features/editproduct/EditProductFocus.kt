package com.gontharuk.wperdenazakupy.presentation.features.editproduct

enum class EditProductFocus {
    NAME,
    CATEGORY,
    DESCRIPTION,
    NONE;

    fun isState(state: EditProductFocus): Boolean {
        return this == state || this == NONE
    }
}