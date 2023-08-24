package com.gontharuk.wperdenazakupy.ui.productlist

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ProductListItem(data: ProductListItemForm) {

    Column {

        Text(text = data.title)

        Text(text = data.description)

        Text(text = data.category)

        Divider(color = Color.Red, thickness = 2.dp)
    }
}