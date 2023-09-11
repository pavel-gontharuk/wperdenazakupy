package com.gontharuk.wperdenazakupy.presentation.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gontharuk.wperdenazakupy.presentation.features.editproduct.EditProductScreen
import com.gontharuk.wperdenazakupy.presentation.features.menu.MenuScreen
import com.gontharuk.wperdenazakupy.presentation.features.productlist.ProductListScreen
import com.gontharuk.wperdenazakupy.presentation.router.targets.EditProductScreenTarget
import com.gontharuk.wperdenazakupy.presentation.router.targets.MenuScreenTarget
import com.gontharuk.wperdenazakupy.presentation.router.targets.ProductListScreenTarget

@Composable
fun MainNavHost(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = MenuScreenTarget.tag) {
        composable(MenuScreenTarget.tag) { MenuScreen(navHostController = navController) }
        composable(ProductListScreenTarget.tag) { ProductListScreen() }
        composable(EditProductScreenTarget.tag) { EditProductScreen() }
    }
}