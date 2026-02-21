package com.basitbhatti.compose.ui_kit.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OTPTextFieldFilled() {

    Box(Modifier.fillMaxWidth()) {

        Row(
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {

            }
        }


    }


}


@Preview
@Composable
private fun OTPPrev() {
    OTPTextFieldFilled()
}