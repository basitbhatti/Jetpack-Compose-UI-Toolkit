package com.basitbhatti.compose.ui_kit.otp

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OTPTextFieldFilled(
    otpText: String,
    maxLength: Int,
    backgroundColor: Color = Color.LightGray,
    onOtpTextChange: (String, Boolean) -> Unit
) {

    val focusRequester = remember { FocusRequester() }

    var isTextFieldFocused by remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current

    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {

        BasicTextField(
            value = otpText,
            onValueChange = {
                if (it.length <= maxLength) {
                    onOtpTextChange(it, it.length == maxLength)
                    if (it.length == maxLength) {
                        keyboardController?.hide()
                    }
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword, imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onFocusChanged{
                    isTextFieldFocused = it.isFocused
                }
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

                val isFocused = otpText.length == index && isTextFieldFocused
                val char = when {
                    index < otpText.length -> otpText[index].toString()
                    else -> ""
                }
                OTPCellFilled(char, isFocused, backgroundColor)

            }
        }

    }


}


@Composable
fun OTPCellFilled(
    char: String, isFocused: Boolean, backgroundColor: Color, modifier: Modifier = Modifier
) {

    val infiniteTransition = rememberInfiniteTransition()
    val cursorAlpha by infiniteTransition.animateFloat(
        initialValue = 0f, targetValue = 1f, animationSpec = infiniteRepeatable(
            animation = tween(500), repeatMode = RepeatMode.Reverse
        )
    )

    val border = BorderStroke(
        1.dp, color = if (isFocused) {
            Color.Black
        } else {
            Color.Transparent
        }
    )

    Box(
        modifier = modifier
            .size(50.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(backgroundColor)
            .border(border = border, shape = RoundedCornerShape(10.dp)),
        contentAlignment = Alignment.Center
    ) {
        if (char.isNotEmpty()) {
            Text(text = char, style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold
            ))
        } else if (isFocused) {
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(15.dp)
                    .background(Color.Black.copy(alpha = cursorAlpha))
            )
        }

    }

}

@Preview
@Composable
private fun OTPPrev() {
    OTPTextFieldFilled("", 4) { txt, isCompleted ->
        
    }
}