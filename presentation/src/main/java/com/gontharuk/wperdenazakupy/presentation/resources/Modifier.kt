package com.gontharuk.wperdenazakupy.presentation.resources

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.cleanClickable(onClick: () -> Unit): Modifier = clickable(
    interactionSource = MutableInteractionSource(),
    indication = null,
    onClick = onClick
)

fun Modifier.default(): Modifier = this
    .fillMaxWidth()
    .padding(16.dp)

fun Modifier.hintEditText(): Modifier = this
    .default()

fun Modifier.button(): Modifier = this
    .default()