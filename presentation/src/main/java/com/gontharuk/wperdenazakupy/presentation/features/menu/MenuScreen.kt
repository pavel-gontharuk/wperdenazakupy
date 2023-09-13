package com.gontharuk.wperdenazakupy.presentation.features.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeButton
import com.gontharuk.wperdenazakupy.presentation.core.view.WperdeText
import com.gontharuk.wperdenazakupy.presentation.router.navigateTarget
import com.gontharuk.wperdenazakupy.presentation.router.targets.EditBucketScreenTarget
import com.gontharuk.wperdenazakupy.presentation.router.targets.EditProductScreenTarget
import com.gontharuk.wperdenazakupy.presentation.router.targets.ProductListScreenTarget

@Composable
fun MenuScreen(navHostController: NavHostController) {
    Column {
        WperdeText(text = "Menu")
        WperdeButton(
            text = "Products",
            onClick = { navHostController.navigateTarget(ProductListScreenTarget) }
        )
        WperdeButton(
            text = "Edit",
            onClick = { navHostController.navigateTarget(EditProductScreenTarget) }
        )
        WperdeButton(
            text = "Edit Bucket",
            onClick = { navHostController.navigateTarget(EditBucketScreenTarget) }
        )
    }
}