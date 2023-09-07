package com.gontharuk.wperdenazakupy.ui.resources

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

sealed class TextConfig(
    val style: TextStyle,
    val modifier: Modifier
) {

    class Header : TextConfig(
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color.Azure,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier
            .default()
    )
}