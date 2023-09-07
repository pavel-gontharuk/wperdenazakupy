package com.gontharuk.wperdenazakupy.ui.editproduct

enum class EditProductFocus {
    NAME,
    CATEGORY,
    DESCRIPTION,
    NONE;

    fun isState(state: EditProductFocus): Boolean {
        return this == state || this == NONE
    }
}