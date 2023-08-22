package com.gontharuk.wperdenazakupy.ui.core.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun WperdeEditText(
    text: String,
    listener: Listener<String>
) {

    BasicTextField(
        value = text,
        onValueChange = { listener.onEvent(it) },
        modifier = Modifier
            .border(2.dp, Color.Black)
            .padding(2.dp)
    )
}