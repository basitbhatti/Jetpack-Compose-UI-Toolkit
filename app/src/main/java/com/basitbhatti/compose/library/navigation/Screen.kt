package com.basitbhatti.compose.ui.library.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String, val title: String, val icon: ImageVector
) {

    object AlertScreen : Screen("alert_screen", "Alert Screen", Icons.Default.AddAlert)

    object HomeScreen : Screen("home_screen", "Home Screen", Icons.Default.Home)

}