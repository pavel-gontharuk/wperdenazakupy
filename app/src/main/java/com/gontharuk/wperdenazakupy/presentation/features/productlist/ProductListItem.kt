package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeText

@Composable
fun ProductListItem(data: ProductListItemForm) {

    Column {

        WperdeText(text = data.title)

        WperdeText(text = data.description)

        Divider(color = Color.Red, thickness = 2.dp)
    }
}