package com.gontharuk.wperdenazakupy.ui.productlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@Preview
@Composable
fun ProductList() {
    val list: List<ProductListItemForm> = List(22) {
        ProductListItemForm(List(10) { Random.nextInt(65, 91).toChar() }.joinToString(""))
    }

    LazyColumn {
        items(list) {
            ProductListItem(data = it)
        }
    }
}