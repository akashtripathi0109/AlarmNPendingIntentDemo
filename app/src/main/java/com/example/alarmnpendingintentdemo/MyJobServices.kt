package com.example.alarmnpendingintentdemo

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Context.JOB_SCHEDULER_SERVICE
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService

class MyJobServices : AppCompatActivity() {

    var jobScheduler: JobScheduler? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_job_services)


        var startJob = findViewById<Button>(R.id.startBtn);
        var stopJob    = findViewById<Button>(R.id.stopBtn);

        startJob.setOnClickListener{
            try{

                Toast.makeText(
                    this, "try block in startjob in : ",
                    Toast.LENGTH_LONG
                ).show()
                Log.d("Start1", "   gvjhguy ")


            jobScheduler=getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
            val componentName=ComponentName(this, MyJobServices::class.java)
            val builder = JobInfo.Builder(123,componentName)
            builder.setMinimumLatency(8000)
            builder.setOverrideDeadline(10000)
            builder.setPersisted(true)
            builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            builder.setRequiresCharging(false)
            jobScheduler!!.schedule(builder.build())}
            catch(e : Exception){
                Toast.makeText(
                    this, "Exception in : "+e.message,
                    Toast.LENGTH_SHORT
                ).show()
                Log.d("Stop1", "   error : "+e)
            }
        }
        stopJob.setOnClickListener {
            if (jobScheduler != null) {
                jobScheduler!!.cancel(123)
                jobScheduler = null
                Toast.makeText(
                    this, "Job Cancelled",
                    Toast.LENGTH_SHORT
                ).show()


            }
        }


    }
}



