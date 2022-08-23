package jp.tm.touchapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // レイアウトからファイル取得
        val et1:EditText = findViewById(R.id.et1)
        val et2:EditText = findViewById(R.id.et2)
        val tvAns:TextView = findViewById(R.id.tvAns)
        val btnAdd:Button = findViewById(R.id.btnAdd)
        val btnClear:Button = findViewById(R.id.btnClear)

        // クリック処理
        btnAdd.setOnClickListener {
            Log.d("Debug", "btnAdd onClick")
            if (et1.text.toString().equals("") || et2.text.toString().equals("")) {
                Log.d("Debug", "EditText Empty")
                // トースト
//                Toast.makeText(this, "数字を入力してください", Toast.LENGTH_LONG).show()

                // アラート用のダイアログ
                AlertDialog.Builder(this)
                    .setTitle("ERRROR!")
                    .setMessage("数字を入力してください")
                    .setPositiveButton("OK", null)
                    .show()

            } else {
                // EditableTextはEditableText型なので、数値型に変換するまでにいくつかの手順を踏む
                // EditableText => String => int と変換する
                val sum:Int = et1.text.toString().toInt() + et2.text.toString().toInt()
                tvAns.text = "合計は" + sum
            }
        }

        // クリアの設定
        btnClear.setOnClickListener {
            et1.text.clear()
            et2.text.clear()
            tvAns.text = "答え"
        }
        Log.d("Debug", "onCreate()")

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