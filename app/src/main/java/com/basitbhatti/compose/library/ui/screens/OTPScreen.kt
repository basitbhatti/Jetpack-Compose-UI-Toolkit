package com.basitbhatti.compose.library.ui.screens

import android.R.attr.maxLength
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.basitbhatti.compose.ui_kit.otp.OTPTextFieldOutlined

@Composable
fun OTPScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .systemBarsPadding()
) {

    var otpTextFilled by remember { mutableStateOf("") }
    var otpTextOutlined by remember { mutableStateOf("") }

    var maxLengthFilled by remember { mutableStateOf(4) }
    var maxLengthOutlined by remember { mutableStateOf(4) }

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
            otpText = otpTextFilled,
            maxLength = maxLengthFilled,
        ) { txt, isCompleted ->
            otpTextFilled = txt
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = maxLengthFilled == 4, onClick = {
                    if (maxLengthFilled != 4) {
                        maxLengthFilled = 4
                        otpTextFilled = ""
                    }
                })

            Spacer(modifier = Modifier.width(5.dp))

            Text("4 Digits")

            Spacer(modifier = Modifier.width(25.dp))

            RadioButton(
                selected = maxLengthFilled == 6, onClick = {
                    if (maxLengthFilled != 6) {
                        maxLengthFilled = 6
                        otpTextFilled = ""
                    }
                })

            Spacer(modifier = Modifier.width(5.dp))

            Text("6 Digits")

        }

        Text("Outlined OTP View Example", modifier.padding(top = 25.dp), style = MaterialTheme.typography.bodyMedium)


        OTPTextFieldOutlined(
            otpText = otpTextOutlined,
            maxLength = maxLengthFilled,
        ) { txt, isCompleted ->
            otpTextOutlined = txt
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            RadioButton(
                selected = maxLengthOutlined == 4, onClick = {
                    if (maxLengthOutlined != 4) {
                        maxLengthOutlined = 4
                        otpTextOutlined = ""
                    }
                })

            Spacer(modifier = Modifier.width(5.dp))

            Text("4 Digits")

            Spacer(modifier = Modifier.width(25.dp))

            RadioButton(
                selected = maxLengthOutlined == 6, onClick = {
                    if (maxLengthOutlined != 6) {
                        maxLengthOutlined = 6
                        otpTextOutlined = ""
                    }
                })

            Spacer(modifier = Modifier.width(5.dp))

            Text("6 Digits")

        }

    }

}