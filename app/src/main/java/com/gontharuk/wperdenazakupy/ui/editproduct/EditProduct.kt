package com.gontharuk.wperdenazakupy.ui.editproduct

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import com.gontharuk.wperdenazakupy.ui.core.keyboard.keyboardShown
import com.gontharuk.wperdenazakupy.ui.core.view.WperdeButton
import com.gontharuk.wperdenazakupy.ui.core.view.WperdeEditText
import com.gontharuk.wperdenazakupy.ui.core.view.WperdeText
import com.gontharuk.wperdenazakupy.ui.editproduct.EditProductFocus.CATEGORY
import com.gontharuk.wperdenazakupy.ui.editproduct.EditProductFocus.DESCRIPTION
import com.gontharuk.wperdenazakupy.ui.editproduct.EditProductFocus.NAME
import com.gontharuk.wperdenazakupy.ui.editproduct.EditProductFocus.NONE
import com.gontharuk.wperdenazakupy.ui.resources.EditTextConfig
import com.gontharuk.wperdenazakupy.ui.resources.button
import com.gontharuk.wperdenazakupy.ui.resources.hintEditText

@Composable
fun EditProduct(
    viewModel: EditProductViewModel,
    state: EditProductState
) {

    var focus: EditProductFocus by remember { mutableStateOf(NONE) }
    val focusManager = LocalFocusManager.current
    val keyboardShown by keyboardShown()

    if (!keyboardShown) focusManager.clearFocus()

    Column(
        modifier = Modifier
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = {
                    focusManager.clearFocus()
                    focus = NONE

                }
            )
            .background(Color.Yellow)
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding(),
        verticalArrangement = Arrangement.Top
    ) {
        WperdeText(text = "Edit Product")
        Column {

            if (focus.isState(CATEGORY)) WperdeEditText(
                text = state.category,
                label = "Category",
                listener = { viewModel.onCategory(it) },
                modifier = Modifier
                    .hintEditText()
                    .onFocusChanged { focusState ->
                        if (focusState.isFocused) focus = CATEGORY
                    },
                config = EditTextConfig.HintEditText()
            )
            if (focus.isState(NAME)) WperdeEditText(
                text = state.name,
                label = "Name",
                listener = { viewModel.onName(it) },
                modifier = Modifier
                    .hintEditText()
                    .onFocusChanged { focusState ->
                        if (focusState.isFocused) focus = NAME
                    },
                config = EditTextConfig.HintEditText()
            )
            if (focus.isState(DESCRIPTION)) WperdeEditText(
                text = state.description,
                label = "Description",
                modifier = Modifier
                    .hintEditText()
                    .onFocusChanged { focusState ->
                        if (focusState.isFocused) focus = DESCRIPTION
                    },
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