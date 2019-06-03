package com.example.relogiodecabeceira

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)

        registerReceiver(broadCastReceiver, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
    }

    override fun onResume() {
        super.onResume()

        runnable.run()

    }

    val broadCastReceiver = object : BroadcastReceiver() {
        override fun onReceive(contxt: Context?, intent: Intent?) {

            val checkBattery: CheckBox = check_battery
            val levelBattery: TextView = text_battery_level

            val level: Int = intent!!.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)

            levelBattery.text = """$level%"""

        }
    }


    val runnable: Runnable = Runnable {
        run {

            val calendar: Calendar = Calendar.getInstance()

            calendar.setTimeInMillis(System.currentTimeMillis())

            val hourMinutes: TextView = text_hour_minute
            val seconds: TextView = text_seconds


            val now: Long = SystemClock.uptimeMillis()
            val next: Long = now + (1000 - (now % 1000))


            val hourMinutesFormat: String =
                String.format("%02d:%02d", calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE))
            val secondFormat: String = String.format("%02d", calendar.get(Calendar.SECOND))

            hourMinutes.text = hourMinutesFormat
            seconds.text = secondFormat

            val mHandler: Handler = Handler()

            mHandler.postAtTime(runnable, next)

        }

    }

}
