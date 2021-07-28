package ru.myitacademy.samsung.backgrounds


import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.TimePicker
import androidx.core.view.isVisible
import androidx.transition.Visibility
import androidx.work.*
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity(),TimePickerDialog.OnTimeSetListener {
    lateinit var am: AlarmManager
    lateinit var myIntent: Intent
    lateinit var myPIntent: PendingIntent
    lateinit var wm: WorkManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myIntent = Intent(this,AlarmReceiver::class.java) //создается намерение для запуска ресивера
        myPIntent = PendingIntent.getBroadcast(applicationContext,100,myIntent,0)//откладывается на время
        am = getSystemService(ALARM_SERVICE) as AlarmManager
        val t4 = OneTimeWorkRequest
            .Builder(Song::class.java)
            .addTag("song")
            .build()
        wm = WorkManager.getInstance(applicationContext)
            wm.enqueue(t4)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val calendar = Calendar.getInstance()                // в активности создаётся календарь времени
        // в него устанавливается время, полученное из TimePicker() через слушателя
        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay)         // в часах (формат 24)
        calendar.set(Calendar.MINUTE,minute)                 //в минутах
        am.setRepeating(AlarmManager.RTC_WAKEUP,calendar.timeInMillis,500,myPIntent) //запускается точно по времени с повторением в 0,5 с. с пробуждением устройства
    }

    fun setMyAlarm(v: View){                            // вызов диалога настройки времени
        val tp = TimePickerFragment()
        tp.show(supportFragmentManager,"picker")
    }


    fun cancelMyAlarm(v: View) {                      //отмена будильника
        am.cancel(myPIntent) //отменяем будильник
    }

    fun calculate(v:View){
        val inData = Data.Builder().putInt("begin",3).putInt("end",20).build()
val t1 = OneTimeWorkRequest.Builder(Calc1::class.java).setInputData(inData).build()
        val t2 = OneTimeWorkRequest.Builder(Calc2::class.java)
            .setConstraints(Constraints.Builder().setRequiresCharging(true).build())
            .build()
        val t3 = OneTimeWorkRequest.from(SleepTread::class.java)
   wm .beginWith(Arrays.asList(t2, t1))
    .then(t3)
    .enqueue()

        }

    override fun onStop() {
        super.onStop()
        wm.cancelAllWorkByTag("song")
        am.cancel(myPIntent)
    }
}