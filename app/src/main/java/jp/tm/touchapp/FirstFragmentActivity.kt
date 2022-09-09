package jp.tm.touchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class FirstFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_fragment)
        Log.d("Debug", "onCreate()")

        val btnFragment1 = findViewById<Button>(R.id.btnfragment1)
        val btnFragment2 = findViewById<Button>(R.id.btnfragment2)

        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl, BlankFragment.newInstance())
                .commit()
        }

        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fl, Blank2Fragment.newInstance())
                .commit()
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