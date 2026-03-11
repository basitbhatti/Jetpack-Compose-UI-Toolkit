package com.basitbhatti.compose.library.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.basitbhatti.compose.ui_kit.ExpandableCard.ExpandableCard

@Composable
fun ExpandableCardScreen(
    modifier: Modifier = Modifier
) {

    Column (
        modifier = modifier.fillMaxSize().windowInsetsPadding(WindowInsets.safeDrawing)
    ) {

        var expanded by remember {
            mutableStateOf(false)
        }

        ExpandableCard(
            expanded = expanded,
            onExpandChange = {
                expanded = !expanded
                Log.d("TAGEXPAND", "$expanded")
            },
            modifier = Modifier.padding(20.dp),
            header = {
                Text("Click here to expand the card.")
            },
            content = {

            }
        )



    }


}