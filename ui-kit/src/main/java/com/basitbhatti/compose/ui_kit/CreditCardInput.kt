package com.basitbhatti.compose.ui_kit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CreditCardInput(
    cardNumber: String,
    onCardNumberChange: (String) -> Unit,
    expiryDate: String,
    onExpiryDateChange: (String) -> Unit,
    cvv: String,
    onCvvChange: (String) -> Unit,
    name: String,
    onNameChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    Column (
        modifier = modifier.fillMaxSize()
    ) {




    }



}


@Composable
fun CardVisual(modifier: Modifier = Modifier) {

    // Credit Card Visual

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color.Black,
                        Color.Black,
                        Color(0xFF00C7FA),
                        Color(0xFF7642E4),
                        Color(0xFFE29DEE),
                    )
                )
            )
    ) {





    }

}


@Preview
@Composable
private fun CardPrev() {
    CardVisual()
}