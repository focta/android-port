package jp.tm.touchapp

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // CountDown　を行うオブジェクトでこれに対する操作を行う
    private lateinit var timer:CountDownTimer

    private var remainingTime: Long = 0

    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Debug", "onCreate()")

        // 時間はミリ秒扱いとなっている
        val startTime: Long = 10_000

        val tv: TextView = findViewById(R.id.tvCountDown)
        val btnStart: Button = findViewById(R.id.btnCountDownStart)
        val btnStop: Button = findViewById(R.id.btnCountDownStop)
        val btnReStart: Button = findViewById(R.id.btnCountDownRestart)
        val btnReset: Button = findViewById(R.id.btnCountDownReset)
        tv.text = "${startTime/1000}"

        btnStart.isEnabled = true
        btnStop.isEnabled = false
        btnReStart.isEnabled = false

        btnStart.setOnClickListener {
            timer = countDownTimer(startTime).start()

            btnStart.isEnabled = false
            btnStop.isEnabled = true
            btnReStart.isEnabled = false
        }

        btnStop.setOnClickListener {
            timer.cancel()

            btnStart.isEnabled = true
            btnStop.isEnabled = false
            btnReStart.isEnabled = true
        }

        btnReStart.setOnClickListener {
            timer = countDownTimer(remainingTime).start()

            btnStart.isEnabled = false
            btnStop.isEnabled = true
            btnReStart.isEnabled = false
        }

        btnReset.setOnClickListener {
            timer.cancel()

            tv.text = "00:00"
            btnStart.isEnabled = true
            btnStop.isEnabled = false
            btnReStart.isEnabled = true

            mp.stop()
            mp.release()
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

    private fun countDownTimer(st:Long): CountDownTimer {

        val tv: TextView = findViewById(R.id.tvCountDown)
        val btnStart: Button = findViewById(R.id.btnCountDownStart)
        val btnStop: Button = findViewById(R.id.btnCountDownStop)
        val btnReStart: Button = findViewById(R.id.btnCountDownRestart)

        return object : CountDownTimer(st, 100) {
            // 引数が残り時間になっている
            override fun onTick(p0: Long) {
                tv.text = "${p0 / 1000}"
                remainingTime = p0
            }

            // タイマー終了時のメソッド
            override fun onFinish() {
                tv.text = "タイムアップ"

                // MediaPlayer.create をメソッドでは、
                // this か this@(Activity名)　のどちらかを起泡しておけばなんとかなるかも・・・
                mp = MediaPlayer.create(this@MainActivity, R.raw.timeup)
                mp.isLooping = true
                mp.start()

                btnStart.isEnabled = true
                btnStop.isEnabled = false
                btnReStart.isEnabled = false
            }
        }

    }

}