package jp.tm.touchapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class FiveScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five_score)

        val tvScore: TextView = findViewById(R.id.tvScore)
        val btnMinus: Button = findViewById(R.id.btnMinus)
        val btnPlus: Button = findViewById(R.id.btnPlus)
        var num = 0

        btnMinus.setOnClickListener {
            num--
            if (num <= -5) {
                val intent = Intent(this, GameOverActivity::class.java)
                startActivity(intent)
                finish()
            }
            tvScore.text = num.toString()
        }

        btnPlus.setOnClickListener {
            num++
            if (num >= 5) {
                val intent = Intent(this, GameClearActivity::class.java)
                startActivity(intent)
            }

            tvScore.text = num.toString()
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