package jp.tm.touchapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Debug", "onCreate()")

        val firstBtn = findViewById<ImageButton>(R.id.mainTabBtnFirst)
        val secondBtn = findViewById<ImageButton>(R.id.mainTabBtnSecond)
        val thirdBtn = findViewById<ImageButton>(R.id.mainTabBtnThird)
        val forthBtn = findViewById<ImageButton>(R.id.mainTabBtnForth)

        // ホームアイコンのタップ時のアクション
        firstBtn.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("POSITION", 1)
            val fragment2 = Fragment2()
            fragment2.arguments = bundle

            supportFragmentManager.beginTransaction()
                .replace(R.id.mainFragment, fragment2)
                .commit()
        }

        secondBtn.setOnClickListener {
            Toast.makeText(this, "Second", Toast.LENGTH_SHORT).show()
        }

        thirdBtn.setOnClickListener {
            Toast.makeText(this, "Third", Toast.LENGTH_SHORT).show()
        }

        forthBtn.setOnClickListener {
            Toast.makeText(this, "Forth", Toast.LENGTH_SHORT).show()
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