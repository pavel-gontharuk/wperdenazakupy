package com.gontharuk.wperdenazakupy.ui.core.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gontharuk.wperdenazakupy.ui.resources.EditTextConfig

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WperdeEditText(
    text: String,
    label: String,
    listener: Listener<String>,
    config: EditTextConfig,
    modifier: Modifier
) {

    OutlinedTextField(
        value = text,
        onValueChange = { listener.onEvent(it) },
        textStyle = config.style,
        modifier = modifier,
        label = {
            Text(text = label)
        },
    )
}