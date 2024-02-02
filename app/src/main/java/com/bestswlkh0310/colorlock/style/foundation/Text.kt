package com.bestswlkh0310.colorlock.style.foundation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bestswlkh0310.colorlock.util.Spacer


@Composable
fun Title(text: String) {
    Row {
        Text(
            modifier = Modifier
                .padding(start = 20.dp),
            text = text,
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Spacer()
    }
}