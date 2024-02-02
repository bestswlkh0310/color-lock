package com.bestswlkh0310.colorlock.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bestswlkh0310.colorlock.feature.lockscreen.LockScreenService
import com.bestswlkh0310.colorlock.style.foundation.ColorlockTheme
import com.bestswlkh0310.colorlock.style.foundation.Title
import com.bestswlkh0310.colorlock.util.Spacer

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorlockTheme {
                Surface {
                    MainScreen({
                        startForegroundService(Intent(applicationContext, LockScreenService::class.java))
                    }) {
                        stopService(Intent(applicationContext, LockScreenService::class.java))
                    }
                }
            }
        }
    }
}