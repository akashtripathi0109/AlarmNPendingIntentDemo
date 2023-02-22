package com.example.alarmnpendingintentdemo

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Context
import android.content.Intent
import android.util.Log

class MyJobService : JobService() {
    override fun onStartJob(p0: JobParameters?): Boolean {

        val i = Intent(this,MyJobService::class.java)
        val pi = PendingIntent.getBroadcast(this, 0,i,0)
        val alarmManager=getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),pi)
        return true
    }

    override fun onStopJob(p0: JobParameters?): Boolean {
        Log.d("Stop", "onStopJob")
        return true
    }

}