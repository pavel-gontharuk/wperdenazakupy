package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gontharuk.wperdenazakupy.presentation.WperdeApplication

@Composable
fun EditProductScreen() {

    val viewModel: EditProductViewModel = viewModel(modelClass = EditProductViewModel::class.java)
    val state: EditProductState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        WperdeApplication.productComponent.inject(viewModel)
    }

    EditProduct(viewModel, state)
}