package com.example.alarmnpendingintentdemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class BroadCastDemo : BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        val mp = MediaPlayer.create(p0,R.raw.alarm)
        mp.start()
        Log.d("hello","AlarmRinging" )
    }
}