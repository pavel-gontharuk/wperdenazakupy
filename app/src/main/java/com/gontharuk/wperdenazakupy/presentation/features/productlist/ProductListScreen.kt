package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.gontharuk.wperdenazakupy.di.DaggerMainComponent
import com.gontharuk.wperdenazakupy.presentation.WperdeApplication
import com.gontharuk.wperdenazakupy.presentation.core.viewmodel.viewModel

@Composable
fun ProductListScreen() {

    val viewModel: ProductListViewModel = viewModel {
        DaggerMainComponent.factory().create(WperdeApplication.dataComponent).getProductListViewModel()
    }
    val state: ProductListState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.fetch()
    }

    ProductList(viewModel, state)
}