package com.basitbhatti.compose.ui_kit.CreditCardInput

import com.basitbhatti.compose.ui_kit.R

data class CardType(
    val name: String,
    val iconResId: Int
) {
    companion object {
        val VISA            = CardType("Visa",            R.drawable.visa)
        val MASTERCARD      = CardType("Mastercard",      R.drawable.mastercard)
        val AMERICAN_EXPRESS = CardType("American Express", R.drawable.amex)
        val UNKNOWN         = CardType("Unknown",         R.drawable.cc_outlined)
    }
}