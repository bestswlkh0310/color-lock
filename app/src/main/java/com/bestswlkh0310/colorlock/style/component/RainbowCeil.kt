package com.bestswlkh0310.colorlock.style.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.colorlock.style.foundation.rainbow

@Composable
fun RainbowCeil(
    modifier: Modifier = Modifier,
    onClick: (Color) -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            Row {
                rainbow.slice(0..<3).forEach { color ->
                    ColorCeil(
                        modifier = Modifier
                            .padding(4.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .clickable {
                                onClick(color)
                            },
                        color = color)
                }
            }
            Row {
                rainbow.slice(3..<6).forEach { color ->
                    ColorCeil(
                        modifier = Modifier
                            .padding(4.dp)
                            .clip(RoundedCornerShape(4.dp))
                            .clickable {
                                onClick(color)
                            },
                        color = color)
                }
            }
        }
    }
}

@Composable
private fun RowScope.ColorCeil(
    modifier: Modifier = Modifier,
    color: Color
) {
    Box(
        modifier = modifier
            .weight(1f)
            .height(100.dp)
            .background(color)
    )
}