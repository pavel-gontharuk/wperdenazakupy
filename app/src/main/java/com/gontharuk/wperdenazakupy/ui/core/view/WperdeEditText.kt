package com.gontharuk.wperdenazakupy.ui.core.view

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import com.gontharuk.wperdenazakupy.ui.resources.EditTextConfig
import com.gontharuk.wperdenazakupy.utils.log

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WperdeEditText(
    text: String,
    label: String,
    listener: Listener<String>,
    config: EditTextConfig,
    modifier: Modifier
) {

    val focusManager = LocalFocusManager.current

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