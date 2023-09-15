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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.wperdenazakupy.presentation.R
import com.gontharuk.wperdenazakupy.presentation.resources.button
import com.gontharuk.wperdenazakupy.presentation.resources.default

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditBucketScreen(
    viewModel: EditBucketViewModel = hiltViewModel()
) {

    val state: EditBucketState by viewModel.state.collectAsState()


    LaunchedEffect(viewModel) {
        viewModel.fetch()
    }

    EditBucket(state, viewModel)


}