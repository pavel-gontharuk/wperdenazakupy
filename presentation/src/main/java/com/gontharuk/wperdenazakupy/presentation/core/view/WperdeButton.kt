package com.gontharuk.wperdenazakupy.presentation.core.view

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WperdeButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Button(
        onClick = onClick,
        modifier = modifier,
    ) {
        WperdeText(text = text)
    }
}