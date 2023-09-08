package com.gontharuk.wperdenazakupy.presentation.core.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.gontharuk.wperdenazakupy.presentation.resources.TextConfig

@Composable
fun WperdeText(text: String) {
    val config = TextConfig.Header()

    Text(
        text = text,
        modifier = config.modifier,
        style = config.style
    )
}