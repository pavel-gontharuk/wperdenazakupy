package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel = hiltViewModel()
) {

    val state: ProductListState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.fetch()
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "TOP",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        val list: List<Int> = List(50) { Random.nextInt(10000, 20000) }

        ItemList(list = list)
        Divider(color = Color.Red, thickness = 2.dp)
        Text(
            text = "BOTTOM",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        /***/
//        Text(
//            text = stringResource(R.string.product_list),
//            style = MaterialTheme.typography.titleLarge,
//            color = MaterialTheme.colorScheme.primary
//        )
//
//        LazyColumn(
//            modifier = Modifier.fillMaxHeight(0.5f)
//        ) {
//            items(state.list) {
//                ProductListItemView(data = it)
//            }
//        }
//
//        Text(
//            text = stringResource(R.string.product_list),
//            style = MaterialTheme.typography.titleLarge,
//            color = MaterialTheme.colorScheme.primary
//        )
    }
}

@Composable
fun ItemList(
    list: List<Int>
) {

    val state = rememberLazyListState()
    val coroutine = rememberCoroutineScope()

    Box {

        LazyColumn(state = state) {
            item {
                Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
            }
            items(list) {
                Text(
                    text = "Item : $it",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }
            item {
                Button(onClick = {
                    coroutine.launch {
                        state.animateScrollToItem(
                            index = 0
                        )
                    }
                }) {
                    Text(text = "Scroll To Top")
                }
            }
            item {
                Spacer(Modifier.windowInsetsBottomHeight(WindowInsets.safeDrawing))
            }
        }
    }
}