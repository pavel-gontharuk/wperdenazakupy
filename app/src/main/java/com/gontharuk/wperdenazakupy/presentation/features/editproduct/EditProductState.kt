package com.gontharuk.wperdenazakupy.presentation.features.editproduct

data class EditProductState(
    val name: String = "",
    val description: String = "",
    val category: String = "",
    val saveBtn: String = "",
    val focus: EditProductFocus = EditProductFocus.NONE,
)