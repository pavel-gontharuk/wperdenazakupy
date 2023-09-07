package com.gontharuk.wperdenazakupy.ui.core.view

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun WperdeButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
    ) {
        WperdeText(text = text)
    }
}