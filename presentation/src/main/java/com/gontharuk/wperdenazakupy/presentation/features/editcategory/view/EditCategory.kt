package com.gontharuk.wperdenazakupy.presentation.features.editcategory.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.gontharuk.wperdenazakupy.presentation.features.editcategory.entity.EditCategoryItemModel
import com.gontharuk.wperdenazakupy.presentation.features.editcategory.entity.EditCategoryState

@Composable
fun EditCategory(
    state: EditCategoryState.Edit,
    onName: (String) -> Unit,
    onItemClicked: (EditCategoryItemModel) -> Unit
) {

    val (selected, deselected) = remember { state.itemList.partition { it.selected } }

    Column {

        OutlinedTextField(
            value = state.name,
            onValueChange = onName
        )

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(selected) {
                EditCategoryItemView(it) { onItemClicked(it) }
            }
            items(deselected) {
                EditCategoryItemView(it) { onItemClicked(it) }
            }
        }
    }
}