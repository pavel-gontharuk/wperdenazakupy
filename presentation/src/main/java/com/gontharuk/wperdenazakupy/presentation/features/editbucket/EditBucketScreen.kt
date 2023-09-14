package com.gontharuk.wperdenazakupy.presentation.features.editbucket

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
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeEditText
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
        state.let { state ->
            when (state) {
                is EditBucketState.EditBucket -> {
                    WperdeText(text = "Edit Bucket")
                    WperdeEditText(
                        text = state.bucket.name,
                        label = "Name",
                        listener = viewModel::nameChanged
                    )
                    LazyColumn {
                        items(state.items.filter { it.selected }) {
                            EditBucketItemView(
                                item = it,
                                onClicked = viewModel::clicked
                            )
                        }
                    }
                    LazyColumn {
                        items(state.items.filter { !it.selected }) {
                            EditBucketItemView(
                                item = it,
                                onClicked = viewModel::clicked
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

                EditBucketState.Loading -> {}
            }
        }
    }
}