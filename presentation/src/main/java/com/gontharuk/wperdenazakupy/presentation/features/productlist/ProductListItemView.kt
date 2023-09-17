package com.gontharuk.wperdenazakupy.presentation.features.productlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListItemViewCollapsed(
    modifier: Modifier = Modifier,
    data: ProductListItemModel,
    onClicked: (ProductListItemModel) -> Unit
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        onClick = { onClicked(data) },
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    top = 5.dp
                )
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary,
                maxLines = 1
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListItemViewExpanded(
    modifier: Modifier = Modifier,
    data: ProductListItemModel,
    onClicked: (ProductListItemModel) -> Unit
) {

    Card(
        modifier = modifier
            .defaultMinSize(minHeight = 64.dp)
            .height(IntrinsicSize.Min)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        onClick = { onClicked(data) },
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    top = 5.dp,
                    bottom = 8.dp
                ),
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = data.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}