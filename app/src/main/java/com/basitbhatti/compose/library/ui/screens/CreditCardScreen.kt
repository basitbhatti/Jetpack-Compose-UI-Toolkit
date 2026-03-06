package com.basitbhatti.compose.library.ui.screens

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.basitbhatti.compose.ui_kit.credit_card_input.CreditCardInput

@Composable
fun CreditCardScreen(
    navController: NavController,
    modifier: Modifier = Modifier.systemBarsPadding()) {


    var cardNumber by remember {
        mutableStateOf("123456789023456")
    }

    var name by remember {
        mutableStateOf("John Doe")
    }

    var expiryDate by remember {
        mutableStateOf("")
    }

    var cvv by remember {
        mutableStateOf("")
    }

    CreditCardInput(
        cardNumber = cardNumber,
        name = name,
        cvv = cvv,
        expiryDate = expiryDate,
        onCardNumberChange = {
            cardNumber = it
        },
        onNameChange = {
            name = it
        },
        onExpiryDateChange = {
            expiryDate = it
        },
        onCvvChange = {
            cvv = it
        }
    )


}