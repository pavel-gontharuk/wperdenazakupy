package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.wperdenazakupy.presentation.R

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel = hiltViewModel()
) {

    val state: ProductListState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.fetch()
    }

    Column {

        Text(
            text = stringResource(R.string.product_list),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        LazyColumn {
            items(state.list) {
                ProductListItem(data = it)
            }
        }
    }
}