package ru.myitacademy.samsung.backgrounds

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class Calc2(c: Context, wp: WorkerParameters): Worker(c,wp) {
    override fun doWork(): Result {
        Log.e("tagg","Calc2 is start")
var m: Long = 0
        var i = Int.MIN_VALUE
        while (i< Int.MAX_VALUE) m += i++
        var data = Data.Builder().putLong("add",m).build()
        Log.e("tagg","Calc2 is complite, m = " + m)
return Result.success(data)
    }

    override fun onStopped() {
        super.onStopped()
    }
}