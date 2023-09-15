package com.gontharuk.wperdenazakupy.presentation.features.editbucket

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.gontharuk.wperdenazakupy.presentation.R
import com.gontharuk.wperdenazakupy.presentation.resources.button
import com.gontharuk.wperdenazakupy.presentation.resources.default

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditBucket(
    state: EditBucketState,
    viewModel: EditBucketViewModel
) {
    Column {
        when (state) {
            is EditBucketState.EditBucket -> {
                Text(
                    text = stringResource(R.string.edit_bucket),
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                OutlinedTextField(
                    value = state.bucket.name,
                    modifier = Modifier.default(),
                    onValueChange = viewModel::nameChanged,
                    textStyle = MaterialTheme.typography.bodyMedium,
                    label = { Text(text = stringResource(R.string.name)) },
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
                Button(
                    onClick = viewModel::save,
                    modifier = Modifier.button()
                ) {
                    Text(
                        text = stringResource(R.string.save),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            }

            EditBucketState.Loading -> {}
        }

    }
}