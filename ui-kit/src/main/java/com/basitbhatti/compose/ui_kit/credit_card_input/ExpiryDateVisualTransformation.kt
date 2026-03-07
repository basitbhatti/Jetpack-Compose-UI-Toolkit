package com.basitbhatti.compose.ui_kit.credit_card_input

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class ExpiryDateVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = text.text.filter { it.isDigit() }.take(4)

        val out = buildString {
            append(trimmed.take(2))           // MM
            if (trimmed.length > 2) {
                append(" / ")                  // space slash space looks nicest
                append(trimmed.drop(2))        // YY
            }
        }

        // Offset mapping – crucial for cursor to behave correctly
        val offsetMapping = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                val originalDigits = offset.coerceAtMost(trimmed.length)
                return when {
                    originalDigits <= 2 -> originalDigits
                    else -> originalDigits + 3   // +1 for space, +1 for /, +1 for space
                }.coerceAtMost(out.length)
            }

            override fun transformedToOriginal(offset: Int): Int {
                val countSlash = if (offset > 2) 3 else 0   // before / → 0, after → 3 chars added
                return (offset - countSlash).coerceAtLeast(0).coerceAtMost(trimmed.length)
            }
        }

        return TransformedText(AnnotatedString(out), offsetMapping)
    }
}