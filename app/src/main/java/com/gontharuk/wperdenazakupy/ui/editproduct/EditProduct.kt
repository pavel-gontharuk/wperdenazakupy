package com.gontharuk.wperdenazakupy.ui.editproduct

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import com.gontharuk.wperdenazakupy.ui.core.view.WperdeButton
import com.gontharuk.wperdenazakupy.ui.core.view.WperdeEditText
import com.gontharuk.wperdenazakupy.ui.core.view.WperdeText
import com.gontharuk.wperdenazakupy.ui.extensions.cleanClickable
import com.gontharuk.wperdenazakupy.ui.resources.EditTextConfig
import com.gontharuk.wperdenazakupy.ui.resources.button
import com.gontharuk.wperdenazakupy.ui.resources.hintEditText

@Composable
fun EditProduct(
    viewModel: EditProductViewModel,
    state: EditProductState
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
                text = state.category,
                label = "Category",
                listener = { viewModel.onCategory(it) },
                modifier = Modifier
                    .hintEditText(),
                config = EditTextConfig.HintEditText()
            )
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
        Spacer(Modifier.weight(1f))
        WperdeButton(
            text = state.saveBtn,
            onClick = { viewModel.save() },
            modifier = Modifier
                .button()
        )
    }
}