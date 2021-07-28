package ru.myitacademy.samsung.backgrounds

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class SleepTread(c: Context, wp: WorkerParameters): Worker(c,wp) {
    override fun doWork(): Result {
        Log.e("tagg","Calc is start")
        val t1 = inputData.getLong("mult",1)
        val t2 = inputData.getLong("add",0)
        Log.e("tagg","add = " + t1 + " mult = " + t2)
        sleep(5000)
        val r = t2.toDouble()/t1
        val output = Data.Builder().putDouble("res",r).build()
        Log.e("tagg","Calc is complite\n result: "+ output.getDouble("res",0.0) )
return Result.success()
    }

    override fun onStopped() {
        super.onStopped()
    }
}