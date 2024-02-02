package com.bestswlkh0310.colorlock.util

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ColumnScope.Spacer(weight: Float = 1f) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(weight))
}

@Composable
fun RowScope.Spacer(weight: Float = 1f) {
    androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(weight))
}
