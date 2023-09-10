package com.gontharuk.wperdenazakupy.presentation.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gontharuk.wperdenazakupy.presentation.features.editproduct.EditProductScreen
import com.gontharuk.wperdenazakupy.presentation.features.menu.MenuScreen
import com.gontharuk.wperdenazakupy.presentation.features.productlist.ProductListScreen

@Composable
fun MainNavHost(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = NavTarget.MENU_SCREEN.tag) {
        composable(NavTarget.MENU_SCREEN.tag) { MenuScreen(navHostController = navController) }
        composable(NavTarget.PRODUCT_LIST.tag) { ProductListScreen() }
        composable(NavTarget.EDIT_PRODUCT_SCREEN.tag) { EditProductScreen() }
    }
}