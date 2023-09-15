package com.gontharuk.wperdenazakupy.presentation.features.editbucket.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gontharuk.wperdenazakupy.presentation.R
import com.gontharuk.wperdenazakupy.presentation.features.editbucket.entity.EditBucketItemModel
import com.gontharuk.wperdenazakupy.presentation.resources.cleanClickable

@Composable
fun EditBucketItemView(
    modifier: Modifier = Modifier,
    item: EditBucketItemModel,
    onClicked: (EditBucketItemModel) -> Unit
) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .cleanClickable { onClicked(item) }
                .fillMaxSize()
                .statusBarsPadding()
                .navigationBarsPadding()
                .imePadding(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = (if (item.selected) R.drawable.baseline_check_box_24
                else R.drawable.baseline_check_box_outline_blank_24).let {
                    painterResource(it)
                },
                null
            )
            Text(
                text = item.name,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center
            )
        }
        Divider(
            color = Color.Black,
            thickness = 1.dp
        )
    }
}