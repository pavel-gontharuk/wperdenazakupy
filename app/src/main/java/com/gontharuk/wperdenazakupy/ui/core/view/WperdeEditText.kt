package com.gontharuk.wperdenazakupy.ui.core.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WperdeEditText(
    text: String,
    label: String,
    listener: Listener<String>
) {

    OutlinedTextField(
        value = text,
        onValueChange = { listener.onEvent(it) },
        label = {
            Text(text = label)
        }
    )
}