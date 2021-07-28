package ru.myitacademy.samsung.backgrounds

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager

class AlarmReceiver: BroadcastReceiver() {  //описываем, как будет работать будильник
    override fun onReceive(context: Context?, intent: Intent?) {
        val alert = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)    //задаём системный звук по умолчанию
        val mp = MediaPlayer.create(context, alert)                              // создаём объект, который будет играть этот звук
        if (mp != null) {                                                         // настраиваем плеер, в том случае, если он создался
            mp.setVolume(100f, 100f)                           //громкость каждой колонки
            mp.start()                                                            // запуск плеера
            mp.setOnCompletionListener { mp -> mp.release() }                     //слушатель для работы плеера
        }
    }
}