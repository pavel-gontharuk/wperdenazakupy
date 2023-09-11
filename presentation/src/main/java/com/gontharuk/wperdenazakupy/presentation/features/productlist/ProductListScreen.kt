package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel = hiltViewModel()
) {

    val state: ProductListState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.fetch()
    }

    ProductList(state)
}