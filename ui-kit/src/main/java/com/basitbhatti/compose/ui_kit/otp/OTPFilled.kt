package com.basitbhatti.compose.ui_kit.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OTPTextFieldFilled(
    otpText: String,
    maxLength: Int,
    backgroundColor: Color = Color.Gray,
    onOtpTextChange: (String, Boolean) -> Unit
) {

    val focusRequester = remember { FocusRequester() }

    Box(Modifier.fillMaxWidth()) {

        BasicTextField(
            value = otpText,
            onValueChange = {
                if (it.length <= maxLength) {
                    onOtpTextChange(it, it.length == maxLength)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .alpha(0f),
            cursorBrush = SolidColor(Color.Transparent)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            repeat(maxLength) { index ->

                val isFocused = otpText.length == index
                val char = when {
                    index < otpText.length -> otpText[index].toString()
                    else -> ""
                }
                OTPCell(char, isFocused, backgroundColor)

            }
        }


        LaunchedEffect(Unit) {
            focusRequester.requestFocus()
        }

    }


}


@Composable
fun OTPCell(
    char: String, isFocused: Boolean, backgroundColor: Color, modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(50.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {

    }

}

@Preview
@Composable
private fun OTPPrev() {
    OTPTextFieldFilled("", 4) { txt, isCompleted ->

    }
}