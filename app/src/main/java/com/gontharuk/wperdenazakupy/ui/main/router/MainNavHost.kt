package com.gontharuk.wperdenazakupy.ui.main.router

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gontharuk.wperdenazakupy.ui.productlist.ProductList

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = NavTarget.PRODUCT_LIST.tag) {
        composable(NavTarget.PRODUCT_LIST.tag) { ProductList() }
    }
}