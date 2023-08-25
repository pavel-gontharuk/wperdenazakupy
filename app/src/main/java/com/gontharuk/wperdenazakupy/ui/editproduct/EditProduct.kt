package com.gontharuk.wperdenazakupy.ui.editproduct

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.sourceInformation
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import com.gontharuk.wperdenazakupy.ui.core.view.WperdeEditText
import com.gontharuk.wperdenazakupy.ui.core.view.WperdeText
import com.gontharuk.wperdenazakupy.ui.resources.EditTextConfig
import com.gontharuk.wperdenazakupy.ui.resources.hintEditText
import com.gontharuk.wperdenazakupy.utils.log

@Composable
fun EditProduct(
    viewModel: EditProductViewModel,
    state: EditProductState
) {

    var focus: EditProductFocus by remember { mutableStateOf(EditProductFocus.NONE) }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier.clickable(
            interactionSource = MutableInteractionSource(),
            indication = null,
            onClick = {
                focusManager.clearFocus()
                focus.log()
                focus = EditProductFocus.NONE

            }
        )
    ) {
        WperdeText(text = "Edit Product")
        Column {

            if (focus == EditProductFocus.CATEGORY || focus == EditProductFocus.NONE) WperdeEditText(
                text = state.category,
                label = "Category",
                listener = { viewModel.onCategory(it) },
                modifier = Modifier
                    .hintEditText()
                    .onFocusChanged { state ->
                        if (state.isFocused) focus = EditProductFocus.CATEGORY
                    },
                config = EditTextConfig.HintEditText()
            )
            if (focus == EditProductFocus.NAME || focus == EditProductFocus.NONE) WperdeEditText(
                text = state.name,
                label = "Name",
                listener = { viewModel.onName(it) },
                modifier = Modifier
                    .hintEditText()
                    .onFocusChanged { state ->
                        if (state.isFocused) focus = EditProductFocus.NAME
                    },
                config = EditTextConfig.HintEditText()
            )
            if (focus == EditProductFocus.DESCRIPTION || focus == EditProductFocus.NONE) WperdeEditText(
                text = state.description,
                label = "Description",
                modifier = Modifier
                    .hintEditText()
                    .onFocusChanged { state ->
                        if (state.isFocused) focus = EditProductFocus.DESCRIPTION
                    },
                listener = { viewModel.onDescription(it) },
                config = EditTextConfig.HintEditText()
            )
        }
        Button(
            onClick = { viewModel.save() },
        ) { Text(text = "save") }
    }
}