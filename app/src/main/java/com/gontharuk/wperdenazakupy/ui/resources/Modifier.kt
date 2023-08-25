package com.gontharuk.wperdenazakupy.ui.resources

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.textDefault(): Modifier = this
    .fillMaxWidth()
    .padding(16.dp)

fun Modifier.hintEditText(): Modifier = this
    .textDefault()