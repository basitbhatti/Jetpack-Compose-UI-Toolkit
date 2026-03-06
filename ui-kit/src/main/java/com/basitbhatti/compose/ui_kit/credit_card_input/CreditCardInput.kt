package com.basitbhatti.compose.ui_kit.credit_card_input

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.VertexMode
import androidx.compose.ui.graphics.Vertices
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(15.dp)
    ) {

        CardVisual(
            cardNumber = cardNumber,
            expiryDate = expiryDate,
            cvv = cvv,
            name = name
        )

        Spacer(Modifier.height(15.dp))

        Text(text = "Card Number", style = MaterialTheme.typography.labelLarge)

        Spacer(Modifier.height(5.dp))

        TextField(
            value = cardNumber.chunked(4).joinToString(" "),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                onCardNumberChange(it)
            },
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

        Row (
            modifier = Modifier.fillMaxWidth()
        ) {

            Column (
                modifier = Modifier.weight(0.5f)
            ) {
                Text(text = "Expiry Date", style = MaterialTheme.typography.labelLarge)

                Spacer(Modifier.height(5.dp))

                TextField(
                    value = expiryDate,
                    onValueChange = {
                        onExpiryDateChange(it)
                    },
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

            Column (
                modifier = Modifier.weight(0.5f)
            ) {
                Text(text = "CVV", style = MaterialTheme.typography.labelLarge)

                Spacer(Modifier.height(5.dp))

                TextField(
                    value = cvv,
                    onValueChange = {
                        onCvvChange(it)
                    },
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

        }


    }


}

@Preview(showBackground = true)
@Composable
private fun CCPrev() {

    AppTheme {
        CreditCardInput(
            cardNumber = "123456789023456",
            expiryDate = "DD/MM",
            cvv = "CVV",
            name = "John Doe",
            onCardNumberChange = {},
            onExpiryDateChange = {},
            onCvvChange = {},
            onNameChange = {}
        )
    }
}


@Composable
fun CardVisual(
    cardNumber: String,
    expiryDate: String,
    cvv: String,
    name: String,
    isFlipped: Boolean = false
) {

    val fontCC = FontFamily(
        Font(R.font.cc, FontWeight.Normal)
    )

    // Credit Card Visual

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

            Spacer(Modifier.height(10.dp))

            Image(
                painter = painterResource(R.drawable.chip), "Chip", modifier = Modifier.size(40.dp)
            )

            Spacer(Modifier.height(15.dp))

            val formattedNumber = cardNumber.chunked(4).joinToString("  ")

            Text(
                text = formattedNumber, fontFamily = fontCC, color = Color.White,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(Modifier.height(15.dp))

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )

                Text(
                    text = expiryDate,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White
                )
            }

            Image(
                painter = painterResource(R.drawable.mastercard),
                contentDescription = "CardType",
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.End),
            )

        }

    }

}


@Preview()
@Composable
private fun CardPrev() {

    AppTheme {

        CardVisual(
            cardNumber = "4532310099991049",
            expiryDate = "12/25",
            cvv = "123",
            name = "John Doe"
        )
    }

}