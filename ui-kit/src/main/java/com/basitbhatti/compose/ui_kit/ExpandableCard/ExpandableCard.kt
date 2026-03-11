package com.basitbhatti.compose.ui_kit.ExpandableCard

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ExpandableCard(
    expanded: Boolean,
    onExpandChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit,
    actionIcon: @Composable (() -> Unit)? = null
) {


    



}