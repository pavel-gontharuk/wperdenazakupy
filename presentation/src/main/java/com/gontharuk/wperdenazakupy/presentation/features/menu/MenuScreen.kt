package com.gontharuk.wperdenazakupy.presentation.features.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.gontharuk.wperdenazakupy.presentation.router.navigateTarget
import com.gontharuk.wperdenazakupy.presentation.router.targets.EditProductScreenTarget
import com.gontharuk.wperdenazakupy.presentation.router.targets.ProductListScreenTarget

@Composable
fun MenuScreen(navHostController: NavHostController) {
    Column {
        Text(text = "Menu")
        Button(onClick = { navHostController.navigateTarget(ProductListScreenTarget) }) { Text(text = "Products") }
        Button(onClick = { navHostController.navigateTarget(EditProductScreenTarget) }) { Text(text = "Edit") }
    }
}