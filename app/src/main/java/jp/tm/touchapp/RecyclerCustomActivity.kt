package jp.tm.touchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerCustomActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_custom)
        Log.d("Debug", "onCreate()")

        val recyclerView = findViewById<RecyclerView>(R.id.rvCustom)
        recyclerView.adapter = RecycleCustomeAdapter()

        recyclerView.layoutManager = LinearLayoutManager(this)
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