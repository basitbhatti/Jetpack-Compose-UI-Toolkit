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
import androidx.compose.material.icons.filled.BatteryAlert
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.basitbhatti.compose.ui.library.ui.theme.AppTheme
import com.basitbhatti.compose.ui_kit.alert.CustomIconAlert
import com.basitbhatti.compose.ui_kit.alert.InputAlertDialog
import com.basitbhatti.compose.ui_kit.alert.LongContentAlertDialog
import com.basitbhatti.compose.ui_kit.alert.SimpleAlertDialog
import com.basitbhatti.compose.ui_kit.alert.SingleButtonAlertDialog

@Composable
fun AlertScreen(
    navController: NavHostController,
    rootModifier: Modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .systemBarsPadding()
) {

    var showSimpleAlert by remember { mutableStateOf(false) }
    var showSingleButtonAlert by remember { mutableStateOf(false) }
    var showLongContentAlert by remember { mutableStateOf(false) }
    var showInputAlert by remember { mutableStateOf(false) }
    var showCustomIconAlert by remember { mutableStateOf(false) }

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
                .padding(start = 15.dp, top = 35.dp, end = 15.dp)
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

        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, top = 15.dp, end = 15.dp)
                .height(50.dp), shape = RoundedCornerShape(5.dp),

            onClick = {
                showLongContentAlert = !showLongContentAlert
            }) {

            Text(
                "Long Content Dialog",
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
                showCustomIconAlert = !showCustomIconAlert
            }) {

            Text(
                "Custom Icon Dialog",
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
                showInputAlert = !showInputAlert
            }) {

            Text(
                "Input Dialog",
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
            )

        }

    }


    Box(
        Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {

        if (showInputAlert) {

            var inputValue by remember { mutableStateOf("") }

            InputAlertDialog(visible = showInputAlert, onDismissRequest = {
                showInputAlert = !showInputAlert
            }, title = {
                Text("Input Field Dialog")
            }, body = {
                Text("This alert dialog has an input field.")
            }, inputField = {
                OutlinedTextField(
                    value = inputValue,
                    onValueChange = { inputValue = it },
                    placeholder = {
                        Text("Enter Email")
                    },
                    leadingIcon = {
                        Icon(imageVector = Icons.Rounded.Email, "Email")
                    }

                )
            }, positiveButton = {
                TextButton(
                    onClick = {
                        showInputAlert = !showInputAlert
                    }) {
                    Text("OK", color = MaterialTheme.colorScheme.onBackground)
                }
            }, negativeButton = {
                TextButton(
                    onClick = {
                        showInputAlert = !showInputAlert
                    }) {
                    Text("Cancel", color = MaterialTheme.colorScheme.onBackground)
                }
            }

            )
        }


        if (showCustomIconAlert) {
            CustomIconAlert(visible = showCustomIconAlert, onDismissRequest = {
                showCustomIconAlert = !showCustomIconAlert
            }, icon = {
                Icon(
                    imageVector = Icons.Default.BatteryAlert, contentDescription = "Icon"
                )
            }, title = {
                Text("Custom Icon Dialog")
            }, body = {
                Text("Body text of the custom icon alert dialog.")

            }, positiveButton = {
                TextButton(
                    onClick = {
                        showCustomIconAlert = !showCustomIconAlert
                    }) {
                    Text("OK", color = MaterialTheme.colorScheme.onBackground)
                }
            }, negativeButton = {
                TextButton(
                    onClick = {
                        showCustomIconAlert = !showCustomIconAlert
                    }) {
                    Text("Cancel", color = MaterialTheme.colorScheme.onBackground)
                }
            })
        }

        if (showLongContentAlert) {
            LongContentAlertDialog(visible = showLongContentAlert, onDismissRequest = {
                showLongContentAlert = !showLongContentAlert
            }, title = {
                Text("Long Content Dialog")
            }, body = {
                Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.")
            }, positiveButton = {
                TextButton(
                    onClick = {
                        showLongContentAlert = !showLongContentAlert
                    }) {
                    Text("OK", color = MaterialTheme.colorScheme.onBackground)
                }
            }, negativeButton = {
                TextButton(
                    onClick = {
                        showLongContentAlert = !showLongContentAlert
                    }) {
                    Text("Cancel", color = MaterialTheme.colorScheme.onBackground)
                }
            })
        }

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
                Text("Body text of the simple alert dialog.")
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

