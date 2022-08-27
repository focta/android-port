package jp.tm.touchapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    // 正解用の判定の配列
    private val quizData = arrayOf("A0","A1","A2","A3")
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Debug", "onCreate()")

        val tvCount: TextView = findViewById(R.id.tvCount)
        val tvQuestion: TextView = findViewById(R.id.tvQuestion)
        val btnQuestion1: TextView = findViewById(R.id.btnQuestion1)
        val btnQuestion2: TextView = findViewById(R.id.btnQuestion2)
        val btnQuestion3: TextView = findViewById(R.id.btnQuestion3)
        val btnQuestion4: TextView = findViewById(R.id.btnQuestion4)

        //　ボタンのテキストの並べ替え
        val list = listOf(0,1,2,3)
        val num = list.shuffled()
        btnQuestion1.text = quizData[num[0]]
        btnQuestion2.text = quizData[num[1]]
        btnQuestion3.text = quizData[num[2]]
        btnQuestion4.text = quizData[num[3]]

        btnQuestion1.setOnClickListener {
            if(btnQuestion1.text == quizData[i]) {
                correctAns()
                i++
                btnQuestion1.isEnabled = false
                tvCount.text = i.toString() + "問正解"
                if (i == 4) tvQuestion.text = "全問正解！"
            } else {
                incorrectAns()
            }
        }

        btnQuestion2.setOnClickListener {
            if(btnQuestion2.text == quizData[i]) {
                correctAns()
                i++
                btnQuestion2.isEnabled = false
                tvCount.text = i.toString() + "問正解"
                if (i == 4) tvQuestion.text = "全問正解！"
            } else {
                incorrectAns()
            }
        }

        btnQuestion3.setOnClickListener {
            if(btnQuestion3.text == quizData[i]) {
                correctAns()
                i++
                btnQuestion3.isEnabled = false
                tvCount.text = i.toString() + "問正解"
                if (i == 4) tvQuestion.text = "全問正解！"
            } else {
                incorrectAns()
            }
        }

        btnQuestion4.setOnClickListener {
            if(btnQuestion4.text == quizData[i]) {
                correctAns()
                i++
                btnQuestion4.isEnabled = false
                tvCount.text = i.toString() + "問正解"
                if (i == 4) tvQuestion.text = "全問正解！"
            } else {
                incorrectAns()
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

    private fun correctAns() {
        AlertDialog.Builder(this)
            .setTitle("正解")
            .setMessage(quizData[i])
            .setPositiveButton("OK", null)
            .show()
    }

    private fun incorrectAns() {
        val tvQuestion: TextView = findViewById(R.id.tvQuestion)
        val btnQuestion1: TextView = findViewById(R.id.btnQuestion1)
        val btnQuestion2: TextView = findViewById(R.id.btnQuestion2)
        val btnQuestion3: TextView = findViewById(R.id.btnQuestion3)
        val btnQuestion4: TextView = findViewById(R.id.btnQuestion4)

        tvQuestion.text = "不正解! Game Over"
        btnQuestion1.isEnabled =false
        btnQuestion2.isEnabled =false
        btnQuestion3.isEnabled =false
        btnQuestion4.isEnabled =false
    }
}