package com.gontharuk.wperdenazakupy.presentation.features.editcategory.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.gontharuk.wperdenazakupy.presentation.R
import com.gontharuk.wperdenazakupy.presentation.core.view.Loading
import com.gontharuk.wperdenazakupy.presentation.features.editcategory.EditCategoryViewModel
import com.gontharuk.wperdenazakupy.presentation.features.editcategory.entity.EditCategoryState

@Composable
fun EditCategoryScreen(
    categoryId: Int,
    viewModel: EditCategoryViewModel = hiltViewModel()
) {

    val state: EditCategoryState by viewModel.state.collectAsState()

    LaunchedEffect(viewModel, categoryId) {
        viewModel.fetch(categoryId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(R.string.edit_category),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )

        state.let {
            when (it) {
                is EditCategoryState.Edit -> EditCategory(
                    state = it,
                    onName = viewModel::onName,
                    onItemClicked = viewModel::itemClicked,
                )

                EditCategoryState.Loading -> Loading()
            }
        }

        Button(onClick = viewModel::save) { Text(text = "Save") }
    }
}