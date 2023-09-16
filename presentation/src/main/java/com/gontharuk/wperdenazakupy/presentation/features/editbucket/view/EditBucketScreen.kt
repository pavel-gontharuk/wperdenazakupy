package com.gontharuk.wperdenazakupy.presentation.features.editbucket.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.wperdenazakupy.presentation.R
import com.gontharuk.wperdenazakupy.presentation.features.editbucket.EditBucketViewModel
import com.gontharuk.wperdenazakupy.presentation.features.editbucket.entity.EditBucketState

@Composable
fun EditBucketScreen(
    viewModel: EditBucketViewModel = hiltViewModel()
) {

    val state: EditBucketState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel) {
        viewModel.fetch()
    }

    Column(
        modifier = Modifier
            .fillMaxHeight()
    ) {
        Text(
            text = stringResource(R.string.edit_bucket),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        state.let {
            when (it) {
                is EditBucketState.EditBucket -> EditBucket(it, viewModel)
                is EditBucketState.Loading -> Loading()
            }
        }
    }
}