package com.gontharuk.wperdenazakupy.ui.productlist

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ProductListItem(data: ProductListItemForm) {
    Text(text = data.name)
}