package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.gontharuk.wperdenazakupy.di.DaggerMainComponent
import com.gontharuk.wperdenazakupy.presentation.WperdeApplication
import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.viewModel

@Composable
fun EditProductScreen() {

    val viewModel: EditProductViewModel = viewModel {
        DaggerMainComponent.factory().create(WperdeApplication.dataComponent).getEditProductViewModel()
    }
    val state: EditProductState by viewModel.state.collectAsState()

    EditProduct(viewModel, state)
}