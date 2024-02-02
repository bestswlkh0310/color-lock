package com.bestswlkh0310.colorlock

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.bestswlkh0310.colorlock.feature.lockscreen.LockScreenService
import com.bestswlkh0310.colorlock.style.foundation.ColorlockTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorlockTheme {
                Surface {
                    Column {
                        Spacer()
                        Row {
                            Spacer()
                            Button(
                                onClick = {
                                    startForegroundService(Intent(applicationContext, LockScreenService::class.java))
                                },
                                content = {
                                    Text("서비스 시작")
                                }
                            )
                            Spacer()
                        }
                        Spacer()
                    }
                }
            }
        }
    }
}

@Composable
fun ColumnScope.Spacer(weight: Float = 1f) {
    Spacer(modifier = Modifier.weight(weight))
}

@Composable
fun RowScope.Spacer(weight: Float = 1f) {
    Spacer(modifier = Modifier.weight(weight))
}