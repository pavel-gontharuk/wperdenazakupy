package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gontharuk.wperdenazakupy.presentation.WperdeApplication

@Composable
fun ProductListScreen() {

    val viewModel: ProductListViewModel by viewModel()
    val state: ProductListState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        //TODO make injection more flexible
        WperdeApplication.productComponent.inject(viewModel)
        viewModel.fetch()
    }

    ProductList(viewModel, state)
}