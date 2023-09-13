package com.gontharuk.wperdenazakupy.presentation.features.editpurchaselist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeButton
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeText
import com.gontharuk.wperdenazakupy.presentation.resources.button

@Composable
fun EditBucketScreen(
    viewModel: EditBucketViewModel = hiltViewModel()
) {

    val state: EditBucketState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.fetch()
    }

    Column {
        WperdeText(text = "Edit Purchase List")
        LazyColumn {
            items(state.list) {
                EditBucketItemView(
                    item = it,
                    onClicked = { viewModel.clicked(it) }
                )
            }
        }
        WperdeButton(
            text = "Save",
            onClick = { viewModel.save() },
            modifier = Modifier
                .button()
        )
    }
}