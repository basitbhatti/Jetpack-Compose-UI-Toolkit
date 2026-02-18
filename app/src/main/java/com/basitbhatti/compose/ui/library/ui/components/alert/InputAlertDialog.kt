package com.basitbhatti.compose.ui.library.ui.components.alert

import android.R.attr.button
import android.R.attr.visible
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputAlertDialog(
    visible: Boolean,
    title: @Composable () -> Unit,
    inputField: @Composable () -> Unit,
    body: @Composable () -> Unit,
    positiveButton: @Composable () -> Unit,
    negativeButton: @Composable () -> Unit
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
                    LocalTextStyle provides MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold
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

                inputField()

                Spacer(Modifier.height(5.dp))

                FlowRow (
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


@Preview
@Composable
private fun InputDialogPrev() {

}