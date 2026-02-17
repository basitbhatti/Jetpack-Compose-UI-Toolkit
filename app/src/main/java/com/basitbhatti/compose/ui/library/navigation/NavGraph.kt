package com.basitbhatti.compose.ui.library.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.basitbhatti.compose.ui.library.ui.screens.AlertScreen
import com.basitbhatti.compose.ui.library.ui.screens.HomeScreen

@Composable
fun NavGraph(controller: NavHostController) {

    NavHost(navController = controller, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(controller)
        }
        composable(Screen.AlertScreen.route) {
            AlertScreen(controller)
        }
    }

}