package com.basitbhatti.compose.library.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.basitbhatti.compose.library.ui.screens.HomeScreen
import com.basitbhatti.compose.library.ui.screens.OTPScreen
import com.basitbhatti.compose.library.ui.screens.AlertScreen

@Composable
fun NavGraph(controller: NavHostController) {

    NavHost(navController = controller, startDestination = Screen.HomeScreen.route) {

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(controller)
        }

        composable(Screen.AlertScreen.route) {
            AlertScreen(controller)
        }

        composable(Screen.OTPScreen.route) {
            OTPScreen(controller)
        }

    }

}