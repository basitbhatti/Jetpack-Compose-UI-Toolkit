package com.basitbhatti.compose.library.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.basitbhatti.compose.ui_kit.otp.OTPTextFieldFilled

@Composable
fun OTPScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .systemBarsPadding()
) {

    var otpText by remember { mutableStateOf("") }

    var maxLength by remember { mutableStateOf(4) }

    Column(
        modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
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

        Text("Filled OTP View Example", style = MaterialTheme.typography.bodyMedium)

        OTPTextFieldFilled(
            otpText = otpText,
            maxLength = maxLength,
        ) { txt, isCompleted ->
            otpText = txt
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = maxLength == 4, onClick = {
                    if (maxLength != 4) {
                        maxLength = 4
                        otpText = ""
                    }
                })

            Spacer(modifier = Modifier.width(5.dp))

            Text("4 Digits")

            Spacer(modifier = Modifier.width(25.dp))

            RadioButton(
                selected = maxLength == 6, onClick = {
                    if (maxLength != 6) {
                        maxLength = 6
                        otpText = ""
                    }
                })

            Spacer(modifier = Modifier.width(5.dp))

            Text("6 Digits")


        }

    }

}