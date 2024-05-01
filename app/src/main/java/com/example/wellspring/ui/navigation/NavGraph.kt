package com.example.wellspring.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wellspring.ui.screens.ChartScreen
import com.example.wellspring.ui.screens.EventsScreen
import com.example.wellspring.ui.screens.MoodScreen
import com.example.wellspring.ui.screens.SignInScreen
import com.example.wellspring.ui.screens.SignUpScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "signin") {
        composable("signin") { SignInScreen(navController) }
        composable("signup") { SignUpScreen(navController) }
        composable("events") { EventsScreen(navController) }
        composable("mood") { MoodScreen(navController) }
        composable("chart") { ChartScreen(navController) }
    }
}
