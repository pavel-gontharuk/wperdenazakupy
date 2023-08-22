package com.gontharuk.wperdenazakupy.ui.editproduct

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.gontharuk.wperdenazakupy.ui.core.view.WperdeEditText

@Composable
fun EditProduct(
    viewModel: EditProductViewModel,
    state: EditProductState
) {

    Column {
        Text(text = "Edit Product")

        Row {

            Column {

                Text(text = "name")

                Text(text = "category")

                Text(text = "description")
            }

            Column {

                WperdeEditText(
                    text = state.name,
                    listener = { viewModel.onName(it) }
                )

                WperdeEditText(
                    text = state.category,
                    listener = { viewModel.onCategory(it) }
                )

                WperdeEditText(
                    text = state.description,
                    listener = { viewModel.onDescription(it) }
                )
            }
        }

        Button(onClick = { viewModel.save() }) { Text(text = "save") }
    }
}