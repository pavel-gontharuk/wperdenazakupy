package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.wperdenazakupy.presentation.R
import com.gontharuk.wperdenazakupy.presentation.resources.theme.Dimensions

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel = hiltViewModel()
) {

    val state: ProductListState by viewModel.state.collectAsState()
    val listState = rememberLazyListState()

    LaunchedEffect(viewModel) {
        viewModel.fetch()
    }

    Column(
        modifier = Modifier
            .padding(
                start = Dimensions.screenPadding,
                end = Dimensions.screenPadding
            )
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.product_list),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        LazyColumn(
            modifier = Modifier.weight(1f),
            state = listState,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(state.list) {
                if (it.expanded) ProductListItemViewExpanded(
                    modifier = Modifier.animateItemPlacement(),
                    data = it,
                    onClicked = viewModel::clicked
                ) else ProductListItemViewCollapsed(
                    modifier = Modifier.animateItemPlacement(),
                    data = it,
                    onClicked = viewModel::clicked
                )
            }
        }
    }
}