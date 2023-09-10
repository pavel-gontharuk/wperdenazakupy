package com.gontharuk.wperdenazakupy.presentation.core.view

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gontharuk.core.utils.log
import com.gontharuk.wperdenazakupy.presentation.resources.EditTextConfig

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
        keyboardActions = KeyboardActions(
            onDone = { "onDone".log() },
            onGo = { "onGo".log() },
            onNext = { "onNext".log() },
            onPrevious = { "onPrevious".log() },
            onSearch = { "onSearch".log() },
            onSend = { "onSend".log() },
        ),
    )
}