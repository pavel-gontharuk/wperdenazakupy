package com.gontharuk.wperdenazakupy.ui.main.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gontharuk.wperdenazakupy.ui.editproduct.EditProductScreen
import com.gontharuk.wperdenazakupy.ui.menu.MenuScreen
import com.gontharuk.wperdenazakupy.ui.productlist.ProductListScreen

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavTarget.MENU_SCREEN.tag) {
        composable(NavTarget.MENU_SCREEN.tag) { MenuScreen(navHostController = navController) }
        composable(NavTarget.PRODUCT_LIST.tag) { ProductListScreen() }
        composable(NavTarget.EDIT_PRODUCT_SCREEN.tag) { EditProductScreen() }
    }
}