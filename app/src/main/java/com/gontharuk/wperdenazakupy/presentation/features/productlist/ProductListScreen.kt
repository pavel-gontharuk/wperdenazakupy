package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ProductListScreen() {

    val viewModel: ProductListViewModel = viewModel { ProductListViewModel(ProductListState()) }
    val state: ProductListState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.fetch()
    }

    ProductList(viewModel, state)
}