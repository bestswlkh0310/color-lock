package com.bestswlkh0310.colorlock.style.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bestswlkh0310.colorlock.util.clClickable

@Composable
fun ColorGrid(
    modifier: Modifier = Modifier,
    colorList: MutableList<Color>,
    onClick: ((Color) -> Unit)? = null
) {
    Column(
        modifier = modifier,
    ) {
        LazyVerticalGrid(
            modifier = Modifier
                .padding(horizontal = 20.dp),
            columns = GridCells.Fixed(3)
        ) {
            items(colorList) { color ->
                ColorCeil(
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .clClickable(
                            rippleEnable = onClick != null
                        ) {
                            onClick?.invoke(color)
                        },
                    color = color
                )
            }
        }
//        Column(
//            modifier = Modifier
//                .padding(horizontal = 20.dp)
//        ) {
//            Row {
//                colorList.slice(0..<3).forEach { color ->
//
//                }
//            }
//            Row {
//                colorList.slice(3..<6).forEach { color ->
//                    ColorCeil(
//                        modifier = Modifier
//                            .padding(4.dp)
//                            .clip(RoundedCornerShape(4.dp))
//                            .clClickable(
//                                rippleEnable = onClick != null
//                            ) {
//                                onClick?.invoke(color)
//                            },
//                        color = color)
//                }
//            }
//        }
    }
}

@Composable
private fun ColorCeil(
    modifier: Modifier = Modifier,
    color: Color
) {
    Box(
        modifier = modifier
            .height(100.dp)
            .background(color)
    )
}