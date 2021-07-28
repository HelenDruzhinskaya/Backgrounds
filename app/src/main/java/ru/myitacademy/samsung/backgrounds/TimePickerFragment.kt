package ru.myitacademy.samsung.backgrounds


import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*


class TimePickerFragment: DialogFragment() {                //чтение настроек с диалогового окна настройки времени
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val calendar = Calendar.getInstance()                // получаем объект календаря
        val h = calendar.get(Calendar.HOUR_OF_DAY)          // читаем часы в формате 24 часа
        val m = calendar.get(Calendar.MINUTE)               //читаем минуты
        // в объект на активности по слушателю настройки времени передаётся время, считанное из окна диалогаЖ часы в формате 24
        return TimePickerDialog(activity,activity as TimePickerDialog.OnTimeSetListener, h, m, true)
    }

}