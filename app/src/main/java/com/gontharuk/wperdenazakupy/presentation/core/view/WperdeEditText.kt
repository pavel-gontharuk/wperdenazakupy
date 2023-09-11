package com.gontharuk.wperdenazakupy.presentation.core.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WperdeEditText(
    text: String,
    label: String,
    modifier: Modifier,
    textStyle: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = Color.Black,
    ),
    listener: Listener<String>,
) {

    OutlinedTextField(
        value = text,
        onValueChange = { listener.onEvent(it) },
        textStyle = textStyle,
        modifier = modifier,
        label = {
            Text(text = label)
        },
    )
}