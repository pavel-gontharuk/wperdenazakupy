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
                Text(text = "description")
                Text(text = "category")
            }

            Column {

                WperdeEditText(
                    text = state.name,
                    label = "Name",
                    listener = { viewModel.onName(it) }
                )
                WperdeEditText(
                    text = state.description,
                    label = "Description",
                    listener = { viewModel.onDescription(it) }
                )
                WperdeEditText(
                    text = state.category,
                    label = "Category",
                    listener = { viewModel.onCategory(it) }
                )
            }
        }

        Button(onClick = { viewModel.save() }) { Text(text = "save") }
    }
}