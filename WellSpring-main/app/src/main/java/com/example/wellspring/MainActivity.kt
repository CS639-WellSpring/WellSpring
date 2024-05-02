package com.example.wellspring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.wellspring.ui.navigation.AppNavGraph
import com.example.wellspring.ui.theme.AppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme { // Make sure to use your theme if you have one defined
                Surface(color = MaterialTheme.colorScheme.background) {
                    AppNavGraph() // This sets up the navigation for your app
                }
            }
        }
    }
}
