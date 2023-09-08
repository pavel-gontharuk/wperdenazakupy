package com.gontharuk.wperdenazakupy.presentation.features.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.gontharuk.wperdenazakupy.presentation.main.router.NavTarget
import com.gontharuk.wperdenazakupy.presentation.main.router.navigateTarget

@Composable
fun MenuScreen(navHostController: NavHostController) {
    Column {
        Text(text = "Menu")
        Button(onClick = { navHostController.navigateTarget(NavTarget.PRODUCT_LIST) }) { Text(text = "Products") }
        Button(onClick = { navHostController.navigateTarget(NavTarget.EDIT_PRODUCT_SCREEN) }) { Text(text = "Edit") }
    }
}