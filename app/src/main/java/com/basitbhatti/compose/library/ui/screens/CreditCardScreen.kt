package com.basitbhatti.compose.library.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.basitbhatti.compose.ui_kit.credit_card_input.CreditCardInput

@Composable
fun CreditCardScreen(
    navController: NavController,
    modifier: Modifier = Modifier) {

    var cardNumber by remember {
        mutableStateOf("")
    }

    var name by remember {
        mutableStateOf("")
    }

    var expiryDate by remember {
        mutableStateOf("")
    }

    var cvv by remember {
        mutableStateOf("")
    }


    Column (
        modifier = modifier.fillMaxSize().systemBarsPadding()
    ) {


        Row (
            modifier = Modifier.fillMaxWidth().height(60.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Row (
                modifier = Modifier.weight(1f)
            ) {

            }


            Row (
                modifier = Modifier.weight(1f)
            ) {

            }


            Row (
                modifier = Modifier.weight(1f)
            ) {

            }

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



}