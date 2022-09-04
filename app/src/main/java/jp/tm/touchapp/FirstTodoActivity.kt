package jp.tm.touchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog

class FirstTodoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_todo)
        Log.d("Debug", "onCreate()")

        val btn: Button = findViewById(R.id.btnAddLv)
        val lv: ListView = findViewById(R.id.lvAddandRemove)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            mutableListOf<String>()
        )

        lv.adapter = adapter

        btn.setOnClickListener {

            val et = EditText(this)
            AlertDialog.Builder(this)
                .setTitle("項目追加")
                .setMessage("何をする？")
                .setView(et)
                .setPositiveButton("追加") { _, _ ->
                    val myTodo = et.text.toString()
                    adapter.add(myTodo)
                }
                .setNegativeButton("キャンセル", null)
                .show()
        }

        // i はタップされたリストのindex番号を示す
        lv.setOnItemClickListener{_, _, i, _ ->
            AlertDialog.Builder(this)
                .setTitle("削除しますか？")
                // 使わない変数は '_' で宣言して良い(GO langと同じ)
                .setPositiveButton("Yes") { _, _ ->
                    adapter.remove(adapter.getItem(i))
                    adapter.notifyDataSetChanged() // ListViewを更新したときに画面更新を行うメソッド

                }
                .setNegativeButton("No", null)
                .show()
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