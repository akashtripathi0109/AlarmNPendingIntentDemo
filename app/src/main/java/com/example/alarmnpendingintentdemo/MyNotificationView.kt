package com.example.alarmnpendingintentdemo

import android.annotation.SuppressLint
import android.app.NotificationManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MyNotificationView : AppCompatActivity() {
    lateinit var notificationManager: NotificationManager
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_notification_view)

        var tv=findViewById<TextView>(R.id.viewNotify)
        var i = MyNotificationDemo()
        tv.text="My text View"
        notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.cancel(i.notificationId)
    }
}