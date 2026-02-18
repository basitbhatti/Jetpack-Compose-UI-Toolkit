package com.basitbhatti.compose.ui.library.ui.components.alert

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LongContentAlertDialog(
    visible: Boolean,
    onDismissRequest: () -> Unit,
    title: @Composable () -> Unit,
    body: @Composable () -> Unit,
    positiveButton: @Composable () -> Unit,
    negativeButton: @Composable () -> Unit,
) {

    if (visible) {

        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 120.dp)
                    .padding(25.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 5.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {

                    Spacer(Modifier.height(10.dp))

                    CompositionLocalProvider(
                        LocalTextStyle provides MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp
                        )
                    ) {
                        title()
                    }

                    Spacer(Modifier.height(5.dp))

                    CompositionLocalProvider(
                        LocalTextStyle provides MaterialTheme.typography.bodyMedium
                    ) {
                        body()
                    }

                    Spacer(Modifier.height(5.dp))

                    FlowRow(
                        maxItemsInEachRow = 2,
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                    ) {

                        negativeButton()

                        positiveButton()

                    }

                }

            }

        }

    }

}


@Preview
@Composable
private fun LongContentDialogPrev() {
    LongContentAlertDialog(
        visible = true,
        onDismissRequest = {

        },
        title = {
            Text("Terms & Conditions")
        },
        body = {
            Text(
                "Terms and conditions text. Terms and conditions text. Terms and conditions text. " +
                        "Terms and conditions text. Terms and conditions text. Terms and conditions text. Terms and conditions text." +
                        " Terms and conditions text. Terms and conditions text. Terms and conditions text. "
            )
        },
        positiveButton = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF0ABBE7)
                ),
                onClick = {}
            ) {
                Text("Accept")
            }
        },
        negativeButton = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x009D9D9D)
                ),
                onClick = {}
            ) {
                Text("Decline", color = Color.DarkGray)
            }
        }
    )
}