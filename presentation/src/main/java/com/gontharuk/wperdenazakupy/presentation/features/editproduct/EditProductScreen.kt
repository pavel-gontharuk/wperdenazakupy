package com.gontharuk.wperdenazakupy.presentation.features.editproduct

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.wperdenazakupy.presentation.R
import com.gontharuk.wperdenazakupy.presentation.resources.cleanClickable
import com.gontharuk.wperdenazakupy.presentation.resources.default

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditProductScreen(
    viewModel: EditProductViewModel = hiltViewModel()
) {

    val state: EditProductState by viewModel.state.collectAsState()
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .cleanClickable { focusManager.clearFocus() }
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .imePadding(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.edit_product),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Column {

            OutlinedTextField(
                value = state.name,
                modifier = Modifier.default(),
                onValueChange = viewModel::onName,
                textStyle = MaterialTheme.typography.bodyMedium,
                label = { Text(text = stringResource(R.string.name)) },
            )
            OutlinedTextField(
                value = state.description,
                modifier = Modifier.default(),
                onValueChange = viewModel::onDescription,
                textStyle = MaterialTheme.typography.bodyMedium,
                label = { Text(text = stringResource(R.string.description)) },
            )
        }
        Button(
            modifier = Modifier.default(),
            onClick = viewModel::save
        ) {
            Text(
                text = stringResource(R.string.save).uppercase(),
                modifier = Modifier.default(),
                style = MaterialTheme.typography.bodyMedium
                    .copy(textAlign = TextAlign.Center),
                color = MaterialTheme.colorScheme.inversePrimary
            )
        }
    }
}