package jp.tm.touchapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CatchCopyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catch_copy)
        Log.d("Debug", "onCreate()")

        val et: EditText = findViewById(R.id.etCatchCopy)
        val btnStart: Button =findViewById(R.id.btnStart2)


        btnStart.setOnClickListener {
            if (et.text.toString()=="") {
                Toast.makeText(this,"なんかかいてやー", Toast.LENGTH_LONG).show()
                Log.d("Debug", "et null")
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("MY_ITEM", et.text.toString())
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