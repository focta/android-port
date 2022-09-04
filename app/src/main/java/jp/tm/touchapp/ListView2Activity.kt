package jp.tm.touchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.SimpleAdapter

class ListView2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view2)
        Log.d("Debug", "onCreate()")

        val lv: ListView = findViewById(R.id.lvMap)

        val list = mutableListOf(
            mapOf<String, String>("main" to "main1", "sub" to "sub1"),
            mapOf<String, String>("main" to "main2", "sub" to "sub2"),
            mapOf<String, String>("main" to "main3", "sub" to "sub3"),
            mapOf<String, String>("main" to "main4", "sub" to "sub4"),
        )

        val adapter = SimpleAdapter(
            this,
            list,
            android.R.layout.simple_list_item_2, // ジャンプしてAndroidが準備したLayoutファイルを確認することができる
            arrayOf("main", "sub"), // データ構造として渡すmapのキーを指定する
            intArrayOf(android.R.id.text1, android.R.id.text2) // 第4引数で指定したそれぞれのキーが、どのレイアウトに当てる値かを指定する。今回だと text1(タイトル): main , text2(詳細): sub という指定になる
        )

        lv.adapter = adapter
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