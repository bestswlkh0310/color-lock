package com.bestswlkh0310.colorlock.feature.changecolorlock

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bestswlkh0310.colorlock.style.component.RainbowCeil
import com.bestswlkh0310.colorlock.style.foundation.Title
import com.bestswlkh0310.colorlock.util.Spacer

@Composable
fun ChangeColorLockScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    modifier = Modifier
                        .padding(start = 8.dp),
                    onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "arrow back")
                }
                Title(text = "Change color lock", 0.dp)
            }
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
        ) {
            RainbowCeil {

            }
            Spacer()
        }
    }
}