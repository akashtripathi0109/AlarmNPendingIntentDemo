package com.example.alarmnpendingintentdemo

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MyNotificationDemo : AppCompatActivity() {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    val notificationId=1234;
    val channelId ="My Channel"
    val title="My Notification"
    val description="My Notification test"

    lateinit var pendingIntent: PendingIntent
    lateinit var bt: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_notification_demo)


        bt=findViewById(R.id.btnNotify)
        bt.setOnClickListener {
            notificationManager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            var i= Intent(this, MyNotificationDemo::class.java)
            pendingIntent=PendingIntent.getActivity(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT)
            createMyChannel()
            notificationManager.notify(notificationId,builder.build())
        }
    }
    fun createMyChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            notificationChannel=NotificationChannel(channelId,description,NotificationManager.IMPORTANCE_HIGH)
            notificationChannel.enableVibration(true)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor= Color.GREEN
            notificationManager.createNotificationChannel(notificationChannel)
            builder=Notification.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(description)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher_foreground))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

        }else{
            builder=Notification.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle(title)
                .setContentText(description)
                .setLargeIcon(BitmapFactory.decodeResource(this.resources,R.drawable.ic_launcher_foreground))
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
        }
    }


    }

