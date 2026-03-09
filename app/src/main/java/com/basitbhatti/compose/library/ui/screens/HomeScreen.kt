package com.basitbhatti.compose.library.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.basitbhatti.compose.library.R
import com.basitbhatti.compose.library.navigation.Screen

@Composable
fun HomeScreen(
    navController: NavController
) {

    var searchValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
            .background(MaterialTheme.colorScheme.background)
            .padding(15.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(top = 15.dp)
        ) {

            Text(text = "Compose UI Kit", style = MaterialTheme.typography.headlineLarge)

        }

        Spacer(Modifier.height(15.dp))

        TextField(
            value = searchValue, onValueChange = {
            searchValue = it
        }, modifier = Modifier
                .fillMaxWidth()
                .shadow(
                    elevation = 2.dp, shape = RoundedCornerShape(16.dp)
                ), shape = RoundedCornerShape(15.dp), colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ), leadingIcon = {
            Icon(
                painter = painterResource(R.drawable.ic_search),
                contentDescription = "Search Icon",
                modifier = Modifier.size(20.dp),
                tint = Color.LightGray
            )
        }, placeholder = {
            Text(text = "Search Components", color = Color.LightGray)
        })


        Spacer(Modifier.height(25.dp))


        FeaturedContent(
            navController = navController
        )

    }

}

@Composable
fun FeaturedContent(navController: NavController) {

    val stroke =
        Stroke(width = 3f, pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f))

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        Text(
            text = "Featured", style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Card(
                modifier = Modifier
                    .height(120.dp)
                    .weight(0.5f)
                    .clickable {
                        navController.navigate(Screen.AlertScreen.route)
                    }, shape = RoundedCornerShape(16.dp), elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.linearGradient(
                                listOf(
                                    Color(0xFF2774AE), Color(0xFF002e5d)
                                )
                            )
                        )
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.ic_alert),
                            contentDescription = "Alert Dialog",
                            tint = Color.White
                        )

                        Spacer(Modifier.height(10.dp))

                        Text(
                            text = "Alert Dialogs",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold, color = Color.White
                            )
                        )

                    }

                }
            }

            Spacer(Modifier.width(15.dp))

            Card(
                modifier = Modifier
                    .height(120.dp)
                    .weight(0.5f)
                    .clickable {
                        navController.navigate(Screen.OTPScreen.route)
                    }, shape = RoundedCornerShape(16.dp), elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.linearGradient(
                                listOf(
                                    Color(0xFF2774AE), Color(0xFF002e5d)
                                )
                            )
                        )
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.ic_otp),
                            tint = Color.White,
                            contentDescription = "OTP Fields"
                        )

                        Spacer(Modifier.height(10.dp))

                        Text(
                            text = "OTP Fields", style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold, color = Color.White
                            )
                        )

                    }

                }
            }


        }

        Spacer(Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {


            Card(
                modifier = Modifier
                    .height(120.dp)
                    .weight(0.5f)
                    .clickable {
                        navController.navigate(Screen.CreditCardScreen.route)
                    }, shape = RoundedCornerShape(16.dp), elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp
                )
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.linearGradient(
                                listOf(
                                    Color(0xFF2774AE), Color(0xFF002e5d)
                                )
                            )
                        )
                ) {

                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.ic_credit_card),
                            tint = Color.White,
                            contentDescription = "Credit Card Input"
                        )

                        Spacer(Modifier.height(10.dp))

                        Text(
                            text = "Credit Card Input",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontWeight = FontWeight.Bold, color = Color.White
                            )
                        )

                    }

                    Text(
                        text = "New",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = 12.sp
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                            .clip(RoundedCornerShape(5.dp))
                            .background(Color.White)
                            .padding(horizontal = 4.dp, vertical = 2.dp)
                            .align(Alignment.TopEnd)

                    )

                }
            }

            Spacer(Modifier.width(15.dp))

            Card(
                modifier = Modifier
                    .height(120.dp)
                    .weight(0.5f)
                    .clickable {

                    }, shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ), elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.dp
                )
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .drawBehind {
                            drawRoundRect(
                                color = Color.Gray.copy(alpha = 0.8f),
                                style = stroke,
                                cornerRadius = CornerRadius(16.dp.toPx())
                            )
                        },
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Icon(
                        painter = painterResource(R.drawable.ic_cards),
                        tint = Color.Gray.copy(alpha = 0.5f),
                        contentDescription = "Expandable Cards"
                    )

                    Spacer(Modifier.height(10.dp))

                    Text(
                        text = "Expandable Cards", style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.Bold, color = Color.Gray.copy(alpha = 0.5f)
                        )
                    )

                }
            }


        }


    }

}