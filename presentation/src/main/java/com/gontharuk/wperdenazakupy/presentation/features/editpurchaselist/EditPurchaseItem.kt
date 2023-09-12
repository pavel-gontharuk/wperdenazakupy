package com.gontharuk.wperdenazakupy.presentation.features.editpurchaselist

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeText
import com.gontharuk.wperdenazakupy.presentation.resources.cleanClickable

@Composable
fun EditPurchaseItemView(
    item: EditPurchaseListItem,
    onClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .cleanClickable { onClicked() }
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding()
    ) {
        Checkbox(
            checked = item.selected,
            onCheckedChange = {}
        )
        WperdeText(text = item.name)
    }
}