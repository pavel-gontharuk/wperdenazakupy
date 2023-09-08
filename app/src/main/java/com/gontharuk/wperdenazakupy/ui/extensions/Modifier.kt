package com.gontharuk.wperdenazakupy.ui.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.Modifier

fun Modifier.cleanClickable(onClick: () -> Unit): Modifier = clickable(
    interactionSource = MutableInteractionSource(),
    indication = null,
    onClick = onClick
)
