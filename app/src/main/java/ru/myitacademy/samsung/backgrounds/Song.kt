package ru.myitacademy.samsung.backgrounds

import android.content.Context
import android.media.MediaPlayer
import androidx.work.Worker
import androidx.work.WorkerParameters

class Song(c: Context, wp: WorkerParameters): Worker(c, wp) {
    override fun doWork(): Result {
        val song: MediaPlayer = MediaPlayer.create(applicationContext, R.raw.two_two)
        song.start()
        return Result.success()
    }

    override fun onStopped() {
        super.onStopped()
    }
}