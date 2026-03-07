package com.basitbhatti.compose.ui_kit.credit_card_input

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class CreditCardVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = text.text.filter { it.isDigit() }.take(16) // max 16 digits for most cards

        val out = buildString {
            for (i in trimmed.indices) {
                if (i > 0 && i % 4 == 0) append(' ')
                append(trimmed[i])
            }
        }

        val originalLength = text.text.length
        val formattedLength = out.length

        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                // How many spaces are inserted before this original position
                var transformed = offset
                var digitsPassed = 0
                for (i in 0 until offset) {
                    if (i > 0 && i % 4 == 0) transformed++ // space was inserted
                    digitsPassed++
                    if (digitsPassed >= trimmed.length) break
                }
                return transformed.coerceAtMost(formattedLength)
            }

            override fun transformedToOriginal(offset: Int): Int {
                var original = 0
                var spacesPassed = 0
                for (i in 0 until offset) {
                    if (i > 0 && i % 4 == 0) spacesPassed++
                    if (i - spacesPassed < trimmed.length) original++
                }
                return original.coerceAtMost(trimmed.length)
            }
        }

        return TransformedText(AnnotatedString(out), offsetMapping)
    }
}