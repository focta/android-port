package jp.tm.touchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class ChronometerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chronometer)
        Log.d("Debug", "onCreate()")

        val cm: Chronometer = findViewById(R.id.cm)
        val btnStart: Button = findViewById(R.id.btnStartChronometer)
        val btnStop: Button = findViewById(R.id.btnStopChronometer)
        val btnReset: Button = findViewById(R.id.btnResetChronometer)
        var offsetTime: Long = 0

        btnStart.setOnClickListener {
            // Chronometer はアプリ起動時からの時間計測を行うため、そのままstart()するとアプリ起動時からの時間がタイマーに表示される
            // cm.baseにてstart時間を再設定して、startボタンを押した段階から時間計測してくれる動作にしている。
            cm.base = SystemClock.elapsedRealtime() - offsetTime
            cm.start()
        }

        btnStop.setOnClickListener {
            cm.stop()
            // Stopが押されたときに、次にStartが押されたときにStopが押された時間から開始できるように
            offsetTime = SystemClock.elapsedRealtime() - cm.base
        }

        btnReset.setOnClickListener {
            cm.base = SystemClock.elapsedRealtime()
            offsetTime = 0
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("Debug", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Debug", "onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Debug", "onPause()")

    }

    override fun onStop() {
        super.onStop()
        Log.d("Debug", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Debug", "onDestroy()")
    }
}