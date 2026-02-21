package com.basitbhatti.compose.library.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController

@Composable
fun OTPScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .systemBarsPadding()
) {

    var otpText by remember { mutableStateOf("") }

    val maxLength by remember { mutableStateOf(4) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }) {
                Icon(Icons.Default.ArrowBack, "Back")
            }

            Text(
                text = "OTP View",
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.bodyMedium
            )

        }



    }


}