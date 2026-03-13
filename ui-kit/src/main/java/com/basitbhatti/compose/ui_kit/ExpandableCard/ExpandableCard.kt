package com.basitbhatti.compose.ui_kit.ExpandableCard

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun ExpandableCard(
    modifier: Modifier = Modifier,
    expanded: Boolean,
    onExpandChange: () -> Unit,
    header: @Composable () -> Unit,
    content: @Composable () -> Unit,
    rotateIcon: Boolean = false,
) {

    val radius by animateDpAsState(
        targetValue = if (expanded) 10.dp else 16.dp, animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium
        )
    )

    val rotation by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f, animationSpec = tween(
            durationMillis = 250, easing = LinearOutSlowInEasing
        )
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 80.dp)
                .toggleable(
                    value = expanded,
                    onValueChange = { onExpandChange() },
                    role = Role.Button
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Spacer(Modifier.width(16.dp))

            Box(
                modifier = Modifier.weight(0.8f),
            ) {
                header()
            }

            Box(
                modifier = Modifier.weight(0.2f),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    Modifier
                        .size(24.dp)
                        .rotate(if (rotateIcon) rotation else 0f)
                )
            }

        }

        AnimatedVisibility(
            visible = expanded, enter = expandVertically(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
                )
            ), exit = shrinkVertically(
                spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
                )
            )

        ) {

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                content()
            }


        }


    }


}