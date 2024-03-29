package com.bestswlkh0310.colorlock.feature.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bestswlkh0310.colorlock.feature.root.Main
import com.bestswlkh0310.colorlock.style.foundation.Title
import com.bestswlkh0310.colorlock.util.Spacer

@Composable
fun HomeScreen(
    navController: NavController,
    startService: () -> Unit,
    stopService: () -> Unit
) {

    var isChecked by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(isChecked) {
        if (isChecked) {
            startService()
        } else {
            stopService()
        }
    }

    Column {
        Spacer()
        Title("Activate color lock")
        Row {
            Switch(
                modifier = Modifier
                    .padding(start = 20.dp),
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
            Spacer()
        }
        Row {
            Spacer()
            Button(onClick = {
                navController.navigate(Main.ChangeColorLock.id) {

                }
            }, content = {
                Text("Change color lock")
            })
            Spacer()
        }
        Spacer()
    }
}