package com.basitbhatti.compose.ui_kit.CreditCardInput

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.VertexMode
import androidx.compose.ui.graphics.Vertices
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basitbhatti.compose.library.ui.theme.AppTheme
import com.basitbhatti.compose.ui_kit.R

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

    var isFlipped by remember {
        mutableStateOf(false)
    }

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val cardType = detectCardType(cardNumber)


    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {

        CardVisual(
            cardType = cardType,
            cardNumber = cardNumber,
            expiryDate = expiryDate,
            cvv = cvv,
            name = name,
            isFlipped = isFlipped
        )

        Spacer(Modifier.height(15.dp))

        Text(text = "Card Number", style = MaterialTheme.typography.labelLarge)

        Spacer(Modifier.height(5.dp))

        TextField(
            value = cardNumber,
            leadingIcon = {
                Image(
                    modifier = Modifier.size(25.dp),
                    painter = painterResource(cardType.iconResId),
                    contentDescription = "Card Icon"
                )
            },
            placeholder = {
                Text("1234  5678  9012  3456")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { newValue ->
                val digitsOnly = newValue.filter { it.isDigit() }.take(16)
                onCardNumberChange(digitsOnly)
            },
            singleLine = true,
            maxLines = 1,
            visualTransformation = CreditCardVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )

        Spacer(Modifier.height(15.dp))

        Text(text = "Name on Card", style = MaterialTheme.typography.labelLarge)

        Spacer(Modifier.height(5.dp))

        TextField(
            value = name,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            onValueChange = {
                onNameChange(it)
            },
            placeholder = {
                Text("John Doe")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )

        Spacer(Modifier.height(15.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.weight(0.5f)
            ) {
                Text(text = "Expiry Date", style = MaterialTheme.typography.labelLarge)

                Spacer(Modifier.height(5.dp))

                TextField(
                    value = expiryDate,
                    onValueChange = { newValue ->
                        val digits = newValue.filter { it.isDigit() }.take(4)
                        if (digits.length == 2) {
                            val month = digits.toIntOrNull() ?: 0
                            if (month in 1..12) {
                                onExpiryDateChange(digits)
                            }
                        } else {
                            onExpiryDateChange(digits)
                        }
                    },
                    placeholder = {
                        Text("MM / YY")
                    },
                    singleLine = true,
                    visualTransformation = ExpiryDateVisualTransformation(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    colors = TextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    )
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            Column(
                modifier = Modifier.weight(0.5f)
            ) {
                Text(text = "CVV", style = MaterialTheme.typography.labelLarge)

                Spacer(Modifier.height(5.dp))

                TextField(
                    value = cvv, onValueChange = { newValue ->
                    val digits = newValue.filter { it.isDigit() }.take(4)
                    onCvvChange(digits)
                }, placeholder = {
                    Text("123")
                }, keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
                ), modifier = Modifier
                        .fillMaxWidth()
                        .onFocusChanged { focusState ->
                            if (cardType != CardType.AMERICAN_EXPRESS) {
                                isFlipped = focusState.isFocused
                            }
                        }, keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        isFlipped = false
                        focusManager.clearFocus()
                    }), shape = RoundedCornerShape(15.dp), colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ))
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun CCPrev() {

    AppTheme {
        CreditCardInput(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            cardNumber = "1234567890123456",
            expiryDate = "MM/YY",
            cvv = "CVV",
            name = "John Doe",
            onCardNumberChange = {},
            onExpiryDateChange = {},
            onCvvChange = {},
            onNameChange = {})
    }
}


@Composable
fun CardVisual(
    cardNumber: String,
    cardType: CardType,
    expiryDate: String,
    cvv: String,
    name: String,
    isFlipped: Boolean = false
) {

    val rotation by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
        label = "cardFlip"
    )

    // Credit Card Visual
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .graphicsLayer(
                rotationY = rotation, cameraDistance = 12f * LocalDensity.current.density
            )

    ) {
        if (rotation <= 90f) {
            CardFront(cardNumber, expiryDate, name, cvv, cardType)
        } else if (cardType != CardType.AMERICAN_EXPRESS) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .graphicsLayer {
                        rotationY = 180f
                    }) {
                CardBack(cvv)
            }
        }

    }
}

@Composable
fun CardBack(cvv: String) {


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
    ) {

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
        ) {

            val w = size.width
            val h = size.height

            val points: List<Offset> = listOf(
                Offset(0f, 0f),
                Offset(w, 0f),
                Offset(0f, h),
                Offset(w, h),
            )

            val colors = listOf(
                Color.Black,
                Color.Blue.copy(alpha = 0.2f),
                Color.Magenta.copy(alpha = 0.5f),
                Color.Blue.copy(alpha = 0.5f),

                )

            val indices = listOf<Int>(
                0, 2, 1, 1, 2, 3
            )

            drawContext.canvas.drawVertices(
                vertices = Vertices(
                    vertexMode = VertexMode.Triangles,
                    positions = points,
                    textureCoordinates = points,
                    colors = colors,
                    indices = indices
                ), blendMode = BlendMode.Dst, paint = Paint()
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            Spacer(Modifier.height(30.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color.Black)
            )

            Spacer(Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(Color.White),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    cvv,
                    style = MaterialTheme.typography.titleMedium,
                    fontStyle = FontStyle.Italic,
                    color = Color.Black,
                    modifier = Modifier.padding(end = 15.dp)
                )
            }


        }


    }

}

@Composable
fun CardFront(
    cardNumber: String, expiryDate: String, name: String, cvv: String, cardType: CardType
) {

    val fontCC = FontFamily(
        Font(R.font.cc, FontWeight.Normal)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
    ) {

        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(15.dp))
        ) {

            val w = size.width
            val h = size.height

            val points: List<Offset> = listOf(
                Offset(0f, 0f),
                Offset(w, 0f),
                Offset(0f, h),
                Offset(w, h),
            )

            val colors = listOf(
                Color.Black,
                Color.Black,
                Color.Blue.copy(alpha = 0.8f),
                Color.Magenta.copy(alpha = 0.5f)
            )

            val indices = listOf<Int>(
                0, 2, 1, 1, 2, 3
            )

            drawContext.canvas.drawVertices(
                vertices = Vertices(
                    vertexMode = VertexMode.Triangles,
                    positions = points,
                    textureCoordinates = points,
                    colors = colors,
                    indices = indices
                ), blendMode = BlendMode.Dst, paint = Paint()
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
        ) {

            Image(
                painter = painterResource(R.drawable.ic_nfs),
                contentDescription = "NFC",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier
                    .size(25.dp)
                    .align(Alignment.End),
            )

            Spacer(Modifier.height(20.dp))

            Image(
                painter = painterResource(R.drawable.chip), "Chip", modifier = Modifier.size(40.dp)
            )

            Spacer(Modifier.height(15.dp))

            val formattedNumber = cardNumber.chunked(4).joinToString("  ")

            Text(
                text = formattedNumber,
                fontFamily = fontCC,
                color = Color.White,
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp)
            )

            Spacer(Modifier.height(15.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Column {
                    Text(
                        text = name,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )

                    Text(
                        text = formatExpiryForDisplay(expiryDate),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )
                }

                if (cardType == CardType.AMERICAN_EXPRESS) {
                    Spacer(Modifier.weight(1f))

                    Text(
                        text = cvv,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.White
                    )

                }
            }


            if (cardType != CardType.UNKNOWN) {
                Image(
                    painter = painterResource(cardType.iconResId),
                    contentDescription = "CardType",
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.End),
                )
            }


        }

    }
}

fun detectCardType(cardNumber: String?): CardType {
    if (cardNumber.isNullOrBlank()) {
        return CardType.UNKNOWN
    }

    // Remove all non-digits
    val cleaned = cardNumber.replace("[^0-9]".toRegex(), "")

    if (cleaned.length < 6) {
        return CardType.UNKNOWN
    }

    val firstDigit = cleaned[0]
    val firstTwo = cleaned.substring(0, 2).toIntOrNull() ?: 0
    val firstFour = cleaned.substring(0, 4).toIntOrNull() ?: 0

    return when {
        // Visa: starts with 4 (length usually 13 or 16)
        firstDigit == '4' -> CardType.VISA

        // Mastercard: 51–55 or 222100–272099 (updated ranges)
        firstTwo in 51..55 || firstFour in 2221..2720 -> CardType.MASTERCARD

        // American Express: starts with 34 or 37
        firstTwo == 34 || firstTwo == 37 -> CardType.AMERICAN_EXPRESS

        else -> CardType.UNKNOWN
    }
}

fun formatExpiryForDisplay(expiryDigits: String): String {
    if (expiryDigits.length <= 2) return expiryDigits
    return "${expiryDigits.take(2)} / ${expiryDigits.drop(2)}"
}

@Preview()
@Composable
private fun CardFrontPrev() {
    AppTheme {
        CardFront(
            cardNumber = "4532310099991049",
            expiryDate = "12/25",
            name = "John Doe",
            "123",
            CardType.VISA
        )
    }

}

@Preview()
@Composable
private fun CardBackPrev() {
    AppTheme {
        CardBack("123")
    }

}