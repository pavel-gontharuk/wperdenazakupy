package com.gontharuk.wperdenazakupy.presentation.core.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun WperdeText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle
) {

    Text(
        text = text,
        modifier = modifier,
        style = style,
    )
}