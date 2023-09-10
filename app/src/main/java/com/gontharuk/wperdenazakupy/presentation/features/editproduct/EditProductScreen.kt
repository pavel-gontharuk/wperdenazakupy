package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.gontharuk.wperdenazakupy.di.features.editproduct.EditProductComponent
import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.viewModel

@Composable
fun EditProductScreen(component: EditProductComponent) {

    val viewModel: EditProductViewModel = viewModel { component.getEditProductViewModel() }
    val state: EditProductState by viewModel.state.collectAsState()

    EditProduct(viewModel, state)
}