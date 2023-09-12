package com.gontharuk.wperdenazakupy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.gontharuk.wperdenazakupy.presentation.resources.theme.WperdenazakupyTheme
import com.gontharuk.wperdenazakupy.presentation.router.MainNavHost
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WperdeActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            WperdenazakupyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainNavHost(navController = navController)
                }
            }
        }
    }
}