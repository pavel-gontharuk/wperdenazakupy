package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeButton
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeEditText
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeText
import com.gontharuk.wperdenazakupy.presentation.resources.button
import com.gontharuk.wperdenazakupy.presentation.resources.cleanClickable
import com.gontharuk.wperdenazakupy.presentation.resources.hintEditText

@Composable
fun EditProductScreen(
    viewModel: EditProductViewModel = hiltViewModel()
) {

    val state: EditProductState by viewModel.state.collectAsState()
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .cleanClickable { focusManager.clearFocus() }
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding(),
        verticalArrangement = Arrangement.Top
    ) {
        WperdeText(text = "Edit Product")
        Column {

            WperdeEditText(
                text = state.name,
                label = "Name",
                listener = { viewModel.onName(it) },
                modifier = Modifier
                    .hintEditText(),
            )
            WperdeEditText(
                text = state.description,
                label = "Description",
                modifier = Modifier
                    .hintEditText(),
                listener = { viewModel.onDescription(it) },
            )
        }
        WperdeButton(
            text = "Save",
            onClick = {
                focusManager.clearFocus()
                viewModel.save()
            },
            modifier = Modifier
                .button()
        )
    }
}