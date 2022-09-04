package jp.tm.touchapp

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class               FirstMediaPlayerActivity : AppCompatActivity() {

    // Media Playerの設定
    private lateinit var mp: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_media_player)

        Log.d("Debug", "onCreate()")


        val tv: TextView = findViewById(R.id.tvLifeCycle)
        val btn: Button = findViewById(R.id.btnLifeCycle)

        btn.setOnClickListener {
            tv.setTextColor(Color.RED)
        }
        mp = MediaPlayer.create(this, R.raw.starlight)
        mp.isLooping = true
        mp.start()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Debug", "onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Debug", "onResume()")

        mp.start()
    }

    override fun onPause() {
        super.onPause()
        Log.d("Debug", "onPause()")

        mp.pause()
    }

    override fun onStop() {
        super.onStop()
        Log.d("Debug", "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Debug", "onDestroy()")

        mp.stop()
        mp.release()
    }

}