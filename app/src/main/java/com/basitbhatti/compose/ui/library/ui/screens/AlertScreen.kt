package com.basitbhatti.compose.ui.library.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.basitbhatti.compose.ui.library.ui.components.alert.SimpleAlertDialog
import com.basitbhatti.compose.ui.library.ui.components.alert.SingleButtonAlertDialog
import com.basitbhatti.compose.ui.library.ui.theme.AppTheme

@Composable
fun AlertScreen(
    navController: NavHostController,
    rootModifier: Modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .systemBarsPadding()
) {

    var showSimpleAlert by remember { mutableStateOf(false) }
    var showSingleButtonAlert by remember { mutableStateOf(false) }

    Column(
        modifier = rootModifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
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
                text = "Alert Dialog",
                fontWeight = FontWeight.Medium,
                style = MaterialTheme.typography.bodyMedium
            )

        }

        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 15.dp, end = 15.dp)
                .height(50.dp), shape = RoundedCornerShape(5.dp), onClick = {
                showSimpleAlert = !showSimpleAlert
            }) {
            Text(
                "Simple Alert Dialog",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
            )
        }

        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 15.dp, end = 15.dp)
                .height(50.dp), shape = RoundedCornerShape(5.dp),

            onClick = {
                showSingleButtonAlert = !showSingleButtonAlert
            }) {

            Text(
                "Single Button Alert Dialog",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
            )
        }

    }


    Box(
        Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {

        if (showSingleButtonAlert) {
            SingleButtonAlertDialog(visible = showSingleButtonAlert, onDismissRequest = {
                showSingleButtonAlert = !showSingleButtonAlert
            }, title = {
                Text("Single Button Alert")
            }, body = {
                Text("Body Text Goes Here")
            }, button = {
                TextButton(
                    onClick = {
                        showSingleButtonAlert = !showSingleButtonAlert
                    }) {
                    Text("OK", color = MaterialTheme.colorScheme.onBackground)
                }
            })
        }


        if (showSimpleAlert) {
            SimpleAlertDialog(visible = showSimpleAlert, onDismissRequest = {
                showSimpleAlert = !showSimpleAlert
            }, title = {
                Text("Simple Alert Example")
            }, body = {
                Text("Body text of the simple alert dailog.")
            }, positiveButton = {
                TextButton(
                    onClick = {
                        showSimpleAlert = !showSimpleAlert
                    }) {
                    Text("OK", color = MaterialTheme.colorScheme.onBackground)
                }
            }, negativeButton = {
                TextButton(
                   onClick = {
                        showSimpleAlert = !showSimpleAlert
                    }) {
                    Text("Cancel", color = MaterialTheme.colorScheme.onBackground)
                }
            })
        }
    }

}

@Preview
@Composable
private fun AlertPrev() {
    AppTheme {
        AlertScreen(rememberNavController())
    }
}

