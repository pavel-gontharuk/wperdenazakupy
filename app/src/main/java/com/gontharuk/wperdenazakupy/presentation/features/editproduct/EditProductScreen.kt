package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun EditProductScreen() {
    val form = EditProductState(saveBtn = "Save")
    val viewModel: EditProductViewModel = viewModel { EditProductViewModel(form) }
    val state: EditProductState by viewModel.state.collectAsState()

    EditProduct(viewModel, state)
}