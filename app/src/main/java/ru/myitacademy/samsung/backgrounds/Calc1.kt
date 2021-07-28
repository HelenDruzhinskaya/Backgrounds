package ru.myitacademy.samsung.backgrounds

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class Calc1(c: Context,wp: WorkerParameters): Worker(c,wp) {
    override fun doWork(): Result {
        Log.e("tagg","Calc1 is start")
        var b = inputData.getInt("begin",1)
        val e = inputData.getInt("end",1)
        Log.e("tagg", "b = "+ b + " e = " + e)
var m: Long = 1
        while (b < e) m *= b++
        var data = Data.Builder().putLong("mult",m).build()
        Log.e("tagg","Calc1 is complite, m = " + m)
return Result.success(data)
    }

    override fun onStopped() {
        super.onStopped()
    }
}