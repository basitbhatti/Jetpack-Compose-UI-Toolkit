package com.basitbhatti.compose.library.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAlert
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String
) {
    object HomeScreen : Screen("home_screen")

    object CreditCardScreen : Screen("credit_card_screen")
    object AlertScreen : Screen("alert_screen")
    object OTPScreen : Screen("otp_screen")
    object ExpandableCardScreen : Screen("expandable_card_screen")


}