package com.gontharuk.wperdenazakupy.presentation.features.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.gontharuk.wperdenazakupy.presentation.R
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeButton
import com.gontharuk.wperdenazakupy.presentation.resources.default
import com.gontharuk.wperdenazakupy.presentation.router.navigateTarget
import com.gontharuk.wperdenazakupy.presentation.router.targets.EditBucketScreenTarget
import com.gontharuk.wperdenazakupy.presentation.router.targets.EditProductScreenTarget
import com.gontharuk.wperdenazakupy.presentation.router.targets.ProductListScreenTarget

@Composable
fun MenuScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.menu),
            modifier = Modifier.default(),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary
        )
        WperdeButton(
            text = stringResource(R.string.products),
            modifier = Modifier.default(),
            onClick = { navHostController.navigateTarget(ProductListScreenTarget) }
        )
        WperdeButton(
            text = stringResource(R.string.edit_product),
            modifier = Modifier.default(),
            onClick = { navHostController.navigateTarget(EditProductScreenTarget) }
        )
        WperdeButton(
            text = stringResource(R.string.edit_bucket),
            modifier = Modifier.default(),
            onClick = { navHostController.navigateTarget(EditBucketScreenTarget) }
        )
    }
}