package com.gontharuk.wperdenazakupy.presentation.core.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun WperdeText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        color = Color.Black,
        textAlign = TextAlign.Center
    )
) {

    Text(
        text = text,
        modifier = modifier,
        style = style,
    )
}