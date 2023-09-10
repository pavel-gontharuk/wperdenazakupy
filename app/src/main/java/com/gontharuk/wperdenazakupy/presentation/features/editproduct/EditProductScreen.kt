package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun EditProductScreen(
    viewModel: EditProductViewModel = hiltViewModel()
) {

    val state: EditProductState by viewModel.state.collectAsState()

    EditProduct(viewModel, state)
}