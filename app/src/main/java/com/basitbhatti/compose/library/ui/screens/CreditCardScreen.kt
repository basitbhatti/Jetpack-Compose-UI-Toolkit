package com.basitbhatti.compose.library.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.basitbhatti.compose.ui_kit.CreditCardInput.CreditCardInput

@Composable
fun CreditCardScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {

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


    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Box(
                    modifier
                        .padding(end = 10.dp)
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.scrim),
                    contentAlignment = Alignment.Center
                ) {
                    Checkbox(
                        checked = true,
                        modifier = Modifier.clip(CircleShape),
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Transparent
                        ),
                        onCheckedChange = {}
                    )
                }

                Text("Order", style = MaterialTheme.typography.titleMedium)

            }

            Row(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Box(
                    modifier
                        .padding(end = 10.dp)
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.scrim),
                    contentAlignment = Alignment.Center
                ) {
                    Checkbox(
                        checked = true,
                        modifier = Modifier.clip(CircleShape),
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Transparent
                        ),
                        onCheckedChange = {}
                    )
                }

                Text("Address", style = MaterialTheme.typography.titleMedium)

            }

            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp, vertical = 15.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .background(
                        MaterialTheme.colorScheme.scrim
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                Text("Payment", style = MaterialTheme.typography.titleMedium, color = Color.White)

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

        Spacer(Modifier.weight(1f))


        Button(
            onClick = {},
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth()
                .height(60.dp),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 5.dp
            ),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor =
                    MaterialTheme.colorScheme.scrim

            )
        ) {

            Text(
                text = "Pay Now",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )

        }


    }



}