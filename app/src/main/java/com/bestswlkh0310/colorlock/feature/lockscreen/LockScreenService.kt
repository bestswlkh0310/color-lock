package com.bestswlkh0310.colorlock.feature.lockscreen

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder

class LockScreenService : Service() {

    private val screenOffReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action == Intent.ACTION_SCREEN_OFF || intent.action == Intent.ACTION_USER_PRESENT) {
                val lockIntent = Intent(context, LockScreenActivity::class.java)
                lockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                lockIntent.action = Intent.ACTION_MAIN
                context.startActivity(lockIntent)
            } else if (intent.action == Intent.ACTION_BOOT_COMPLETED) {
                val tempService = Intent(context, LockScreenService::class.java)
                context.startForegroundService(tempService)
            }
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    @SuppressLint("ForegroundServiceType")
    override fun onCreate() {
        super.onCreate()
        val filter = IntentFilter(Intent.ACTION_SCREEN_OFF)
        filter.addAction(Intent.ACTION_USER_PRESENT)
        registerReceiver(screenOffReceiver, filter)

        val CHANNEL_ID = "gang"

        val notificationChannel =
            NotificationChannel(CHANNEL_ID, "My Service", NotificationManager.IMPORTANCE_DEFAULT)
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(notificationChannel)
        val notification = Notification.Builder(this, CHANNEL_ID)
            .setContentTitle("My Service")
            .setContentText("Service is running...")
            .build()

        startForeground(1, notification)
    }

    //서비스가 종료될때 정리할 리소스 넣어주기
    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(screenOffReceiver)
    }
}