package jp.tm.touchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.*

class DivinationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_divination)

        Log.d("Debug", "onCreate()")
        val ut: TextView = findViewById(R.id.uranaiText)
        val ub: Button = findViewById(R.id.uranaiBtn)

        ub.setOnClickListener {
            // 配列のサイズの確認、sizeでもcount()でも対応できる・・・、どう違うのだろう
//            val uranai = arrayOf("大吉", "中吉", "小吉", "凶")
//            val num = Random().nextInt(uranai.count())
            val uranai = arrayOf(11, 12, 13, 14)
            Log.d("Debug count", uranai.count().toString())
            Log.d("Debug size", uranai.size.toString())

            val num = Random().nextInt(uranai.count())

//            ut.text = num.toString()
            ut.text = uranai.get(num).toString()
            Log.d("Debug", "お試し")
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