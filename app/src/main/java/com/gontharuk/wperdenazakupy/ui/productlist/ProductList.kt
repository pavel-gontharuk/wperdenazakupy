package com.gontharuk.wperdenazakupy.ui.productlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import kotlin.random.Random

@Composable
fun ProductList(
    viewModel: ProductListViewModel,
    state: ProductListState
) {

    Column {

        Text(text = "Product List")

        LazyColumn {
            items(state.list) {
                ProductListItem(data = it)
            }
        }
    }
}