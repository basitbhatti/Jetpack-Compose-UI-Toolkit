package com.basitbhatti.compose.ui.library.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.basitbhatti.compose.ui.library.navigation.Screen

@Composable
fun HomeScreen(navController: NavHostController) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
                .height(60.dp)
        ) {

            OutlinedButton(
                modifier = Modifier.weight(0.5f).padding(horizontal = 10.dp),
                shape = RoundedCornerShape(5.dp),
                onClick = {
                    navController.navigate(Screen.AlertScreen.route)
                }
            ) {
                Text("Alert Dialogs")
            }

            OutlinedButton(
                modifier = Modifier.weight(0.5f).padding(horizontal = 10.dp),
                shape = RoundedCornerShape(5.dp),
                onClick = {
                    navController.navigate(Screen.OTPScreen.route)
                }
            ) {
                Text("OTP View")
            }

        }


    }
}
