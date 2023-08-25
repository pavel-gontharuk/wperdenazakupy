package com.gontharuk.wperdenazakupy.ui.resources

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

sealed class EditTextConfig(
    val style: TextStyle,
    val modifier: Modifier,
) {

    class HintEditText : EditTextConfig(
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.Black,
        ),
        modifier = Modifier
            .textDefault()
    )
}