package jp.tm.touchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        val lv: ListView = findViewById(R.id.lv)
        val data = arrayOf(
            "ライオン", "クマ", "キリン", "ゾウ", "パンダ", "コアラ", "キリン", "サル", "ヒョウ",
            "ゴリラ", "カバ", "カピバラ", "リス", "ワニ", "ハムスター", "ヒツジ", "ネコ"
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            data
        )

        lv.adapter = adapter

        lv.setOnItemClickListener { adapterView, view , i, l ->
            Toast.makeText(this, data[i], Toast.LENGTH_LONG).show()
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