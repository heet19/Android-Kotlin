package com.example.notificationapp

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App: Application() {

    final private val CHENNEL_ID1="CHENNEL_ID1"
    final private val CHENNEL_ID2="CHENNEL_ID2"

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(CHENNEL_ID1,
                "Channel 1 ", NotificationManager.IMPORTANCE_HIGH)
            channel1.description = "this my high important channel for notification"
            val channel2 = NotificationChannel(CHENNEL_ID2,
            "Channel 2 ", NotificationManager.IMPORTANCE_DEFAULT)
            channel2.description = "this my default important channel for notification"

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            manager.createNotificationChannel(channel1)
            manager.createNotificationChannel(channel2)
        }
    }
}