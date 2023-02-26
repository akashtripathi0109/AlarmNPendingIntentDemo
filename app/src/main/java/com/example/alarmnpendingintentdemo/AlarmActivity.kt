package com.example.alarmnpendingintentdemo

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.getSystemService
import kotlinx.coroutines.NonCancellable.start

class AlarmActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        var start = findViewById<Button>(R.id.start)
        var cancel = findViewById<Button>(R.id.cancel)
        var repeat  = findViewById<Button>(R.id.repeat)
        var et = findViewById<EditText>(R.id.time)

        val i = Intent(this,BroadCastDemo::class.java)
        var alarmManager : AlarmManager
        val pi = PendingIntent.getBroadcast(this, 0,i,0)
        start.setOnClickListener{
            val e = et.text.toString().toInt()
            alarmManager  = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(e*1000), pi)
            Toast.makeText(this,"Alarm is Set", Toast.LENGTH_SHORT).show()
        }
        cancel.setOnClickListener {
            alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            alarmManager.cancel(pi)
            Toast.makeText(this,"Alarm Cancelled", Toast.LENGTH_SHORT).show()
        }

        repeat.setOnClickListener{
            val e = et.text.toString().toInt()
            alarmManager  = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),5000, pi)
            Toast.makeText(this,"Repeating Alarm is Set", Toast.LENGTH_SHORT).show()
        }
    }
}