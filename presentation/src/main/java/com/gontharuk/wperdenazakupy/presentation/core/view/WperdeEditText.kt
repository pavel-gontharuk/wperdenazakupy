package com.gontharuk.wperdenazakupy.presentation.core.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WperdeEditText(
    text: String,
    label: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        color = MaterialTheme.colorScheme.primary,
    ),
    listener: Listener<String> = Listener { },
) {

    var textState by remember { mutableStateOf(TextFieldValue(text = text)) }

    OutlinedTextField(
        value = textState,
        onValueChange = { textState = it },
        textStyle = textStyle,
        modifier = modifier,
        label = {
            Text(text = label)
        },
    )

    LaunchedEffect(textState) {
        delay(300)
        listener.onEvent(textState.text)
    }
}