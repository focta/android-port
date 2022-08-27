package jp.tm.touchapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FirstPutExtraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_put_extra)
        val et: EditText = findViewById(R.id.et3)
        val btnStart: Button = findViewById(R.id.btnStart1)

        btnStart.setOnClickListener {
            if (et.text.toString() == ("")) {
                Toast.makeText(this, "なにか入力してください", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, SecondPutExtraActivity::class.java)
                intent.putExtra("MY_NAME", et.text.toString())
                startActivity(intent)
            }

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