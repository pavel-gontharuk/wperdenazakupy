package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gontharuk.wperdenazakupy.presentation.WperdeApplication
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeButton
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeEditText
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeText
import com.gontharuk.wperdenazakupy.presentation.extensions.cleanClickable
import com.gontharuk.wperdenazakupy.presentation.resources.EditTextConfig
import com.gontharuk.wperdenazakupy.presentation.resources.button
import com.gontharuk.wperdenazakupy.presentation.resources.hintEditText

@Composable
fun EditProduct(
    viewModel: EditProductViewModel,
    state: EditProductState,
) {

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
                config = EditTextConfig.HintEditText()
            )
            WperdeEditText(
                text = state.description,
                label = "Description",
                modifier = Modifier
                    .hintEditText(),
                listener = { viewModel.onDescription(it) },
                config = EditTextConfig.HintEditText()
            )
        }
        WperdeButton(
            text = "Save",
            onClick = { viewModel.save() },
            modifier = Modifier
                .button()
        )
    }
}