package com.basitbhatti.compose.ui_kit

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.VertexMode
import androidx.compose.ui.graphics.Vertices
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basitbhatti.compose.library.ui.theme.AppTheme

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
        modifier = modifier.fillMaxSize()
    ) {


    }


}


@Composable
fun CardVisual(
    cardNumber: String,
    expiryDate: String,
    cvv: String,
    name: String,
) {

    // Credit Card Visual


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)

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

//            val colors = listOf(
//                Color.Black,
//                Color.Black,
//                Color(0xFFFED049).copy(0.5f),
//                Color(0xFFF93232).copy(0.5f),
//            )

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
                .padding(20.dp),
        ) {


            Image(
                painter = painterResource(R.drawable.nfc),
                "NFC",
                modifier = Modifier
                    .padding(10.dp)
                    .size(20.dp)
                    .align(Alignment.End),
            )

            Image(
                painter = painterResource(R.drawable.chip), "Chip", modifier = Modifier.size(40.dp)
            )

            Spacer(Modifier.height(10.dp))

            Text(
                text = cardNumber,
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 24.sp),
                color = Color.White
            )

            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = name,
                    style = MaterialTheme.typography.headlineMedium.copy(fontSize = 20.sp),
                    color = Color.White
                )

                Spacer(Modifier.weight(1f))

                Text(
                    text = expiryDate,
                    style = MaterialTheme.typography.headlineMedium.copy(fontSize = 20.sp),
                    color = Color.White
                )

            }


        }

    }

}


@Preview()
@Composable
private fun CardPrev() {

    AppTheme {

        CardVisual(
            cardNumber = "4532  3100  9999  1049",
            expiryDate = "12/25",
            cvv = "123",
            name = "John Doe"
        )
    }

}