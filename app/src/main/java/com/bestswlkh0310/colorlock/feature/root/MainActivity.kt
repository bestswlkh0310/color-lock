package com.bestswlkh0310.colorlock.feature.root

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bestswlkh0310.colorlock.feature.lockscreen.LockScreenService
import com.bestswlkh0310.colorlock.feature.main.HomeScreen
import com.bestswlkh0310.colorlock.style.foundation.ColorlockTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorlockTheme {
                Surface {
                    NavigationGraph(startService = {
                        startForegroundService(Intent(applicationContext, LockScreenService::class.java))
                    }) {
                        stopService(Intent(applicationContext, LockScreenService::class.java))
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController(),
    startService: () -> Unit,
    stopService: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Main.Home.id
    ) {
        composable(Main.Home.id) {
            HomeScreen(navController, startService, stopService)
        }
        composable(Main.ChangeColorLock.id) {
            Text(text = "change color lock screen")
        }
    }
}

sealed class Main(val id: String) {
    data object Home: Main("main")
    data object ChangeColorLock: Main("change color lock")
}