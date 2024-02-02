package com.bestswlkh0310.colorlock.feature.changecolorlock

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bestswlkh0310.colorlock.style.component.ColorGrid
import com.bestswlkh0310.colorlock.style.foundation.Title
import com.bestswlkh0310.colorlock.style.foundation.gray100
import com.bestswlkh0310.colorlock.style.foundation.rainbow
import com.bestswlkh0310.colorlock.util.Spacer

@Composable
fun ChangeColorLockScreen(
    navController: NavController
) {

    var chooseColors = remember { mutableStateListOf<Color>() }
    val context = LocalContext.current

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
            Title("Choose color")
            ColorGrid(
                colorList = rainbow
            ) { color ->
                if (chooseColors.size >= 12) {
                    Toast.makeText(context, "too long", Toast.LENGTH_SHORT).show()
                    return@ColorGrid
                }
                chooseColors.add(color)
            }

            ColorGrid(colorList = chooseColors)
            Spacer()
        }
    }
}