package com.gontharuk.wperdenazakupy.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.gontharuk.wperdenazakupy.di.layers.ComponentProvider
import com.gontharuk.wperdenazakupy.presentation.router.MainNavHost
import com.gontharuk.wperdenazakupy.presentation.main.theme.WperdenazakupyTheme

class WperdeActivity : ComponentActivity() {

    private val componentProvider: ComponentProvider by lazy {
        application as WperdeApplication
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            WperdenazakupyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainNavHost(
                        navController = navController,
                        provider = componentProvider
                    )
                }
            }
        }
    }
}