package com.gontharuk.wperdenazakupy.presentation.features.editcategory.view

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.gontharuk.wperdenazakupy.presentation.R
import com.gontharuk.wperdenazakupy.presentation.features.editcategory.entity.EditCategoryItemModel
import com.gontharuk.wperdenazakupy.presentation.resources.cleanClickable

@Composable
fun EditCategoryItemView(
    model: EditCategoryItemModel,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .cleanClickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = (if (model.selected) R.drawable.baseline_check_box_24
            else R.drawable.baseline_check_box_outline_blank_24).let {
                painterResource(it)
            }, null
        )
        Text(model.name)
    }
}