package jp.tm.touchapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class MultiQuizActivity : AppCompatActivity() {


    private val quizTitle = arrayOf("問題A", "問題B", "問題C", "問題D")
    private val quizData = arrayOf(
        arrayOf("A0", "A1", "A2", "A3"),
        arrayOf("B0", "B1", "B2", "B3"),
        arrayOf("C0", "C1", "C2", "C3"),
        arrayOf("D0", "D1", "D2", "D3"),
    )

    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multi_quiz)
        Log.d("Debug", "onCreate()")

        val tvCount: TextView = findViewById(R.id.tvCount2)
        val tvQuestion: TextView = findViewById(R.id.tvQuestion2)
        val btn0: Button = findViewById(R.id.btnQuestionMulti1)
        val btn1: Button = findViewById(R.id.btnQuestionMulti2)
        val btn2: Button = findViewById(R.id.btnQuestionMulti3)
        val btn3: Button = findViewById(R.id.btnQuestionMulti4)
        val btnNext: Button = findViewById(R.id.btnNext)

        tvCount.text = "あと4問"
        tvQuestion.text = quizTitle[0]
        btnNext.isEnabled = false

        val list = listOf(0, 1, 2, 3)
        val num = list.shuffled()

        btn1.text = quizData[0][num[1]]
        btn2.text = quizData[0][num[2]]
        btn3.text = quizData[0][num[3]]
        btn0.text = quizData[0][num[0]]

        btn0.setOnClickListener {
            if (btn0.text == quizData[i][0]) {
                correctAns()
            } else {
                incorrectAns()
            }
        }

        btn1.setOnClickListener {
            if (btn1.text == quizData[i][0]) {
                correctAns()
            } else {
                incorrectAns()
            }
        }

        btn2.setOnClickListener {
            if (btn2.text == quizData[i][0]) {
                correctAns()
            } else {
                incorrectAns()
            }
        }

        btn3.setOnClickListener {
            if (btn3.text == quizData[i][0]) {
                correctAns()
            } else {
                incorrectAns()
            }
        }

        btnNext.setOnClickListener {
            i++
            val numNext = list.shuffled()

            tvCount.text = "あと" + (4-i) + "問"
            tvQuestion.text = quizTitle[i]
            btnNext.isEnabled = false

            btn0.text = quizData[i][numNext[0]]
            btn1.text = quizData[i][numNext[1]]
            btn2.text = quizData[i][numNext[2]]
            btn3.text = quizData[i][numNext[3]]

            btn0.isEnabled = true
            btn1.isEnabled = true
            btn2.isEnabled = true
            btn3.isEnabled = true
            btnNext.isEnabled = false

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

        if (i >= 3) {
            val intent = Intent(this, GameClearActivity::class.java)
            startActivity(intent)
            finish()
        }

        val btn0: Button = findViewById(R.id.btnQuestionMulti1)
        val btn1: Button = findViewById(R.id.btnQuestionMulti2)
        val btn2: Button = findViewById(R.id.btnQuestionMulti3)
        val btn3: Button = findViewById(R.id.btnQuestionMulti4)
        val btnNext: Button = findViewById(R.id.btnNext)

        AlertDialog.Builder(this)
            .setTitle("正解")
            .setMessage(quizData[i][0])
            .setPositiveButton("OK", null)
            .show()

        btn0.isEnabled = false
        btn1.isEnabled = false
        btn2.isEnabled = false
        btn3.isEnabled = false
        btnNext.isEnabled = true
    }

    private fun incorrectAns() {
        val tvQuestion: TextView = findViewById(R.id.tvQuestion2)
        val btn0: Button = findViewById(R.id.btnQuestionMulti1)
        val btn1: Button = findViewById(R.id.btnQuestionMulti2)
        val btn2: Button = findViewById(R.id.btnQuestionMulti3)
        val btn3: Button = findViewById(R.id.btnQuestionMulti4)
        val btnNext: Button = findViewById(R.id.btnNext)

        tvQuestion.text = "不正解！"
        btn0.isEnabled = false
        btn1.isEnabled = false
        btn2.isEnabled = false
        btn3.isEnabled = false
        btnNext.isEnabled = false
    }

}