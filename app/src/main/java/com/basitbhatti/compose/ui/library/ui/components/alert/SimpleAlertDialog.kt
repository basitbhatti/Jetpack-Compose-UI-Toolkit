package com.basitbhatti.compose.ui.library.ui.components.alert

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleAlertDialog(
    visible: Boolean,
    title: @Composable () -> Unit,
    body: @Composable () -> Unit,
    positiveButton: @Composable () -> Unit,
    negativeButton: @Composable () -> Unit,
) {

    AnimatedVisibility(
        visible = visible, enter = fadeIn(
            animationSpec = tween(220)
        ) + scaleIn(
            initialScale = 0.9f, animationSpec = tween(220)
        ), exit = fadeOut(
            animationSpec = tween(220)
        ) + scaleOut(
            targetScale = 0.95f, animationSpec = tween(220)
        )
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

                Spacer(Modifier.height(5.dp))

                CompositionLocalProvider(
                    LocalTextStyle provides MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Medium
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

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(0.7f),
                        horizontalArrangement = Arrangement.End
                    ) {

                        negativeButton()

                        Spacer(Modifier.width(5.dp))

                        positiveButton()

                    }

                }

            }

        }

    }

}


@Preview
@Composable
private fun SimpleAlertPrev() {
    SimpleAlertDialog(
        visible = true,
        title = {
            Text("Exit App?")
        },
        body = {
            Text("Exiting this app discard unsaved changes.")
        },
        positiveButton = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE70A0A)
                ),
                onClick = {}
            ) {
                Text("Exit")
            }
        },
        negativeButton = {
            Button(
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0x009D9D9D)
                ),
                onClick = {}
            ) {
                Text("Cancel", color = Color.DarkGray)
            }
        }
    )
}