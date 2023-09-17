package com.gontharuk.wperdenazakupy.presentation.router

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

@Composable
fun BottomNavHost() {

    val navController = rememberNavController()

    Scaffold(
        bottomBar = BottomNavigationView(

        )
    ) {
        NavHost(navController =, graph =)
    }
}