package jp.tm.touchapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import java.util.Random

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult: TextView = findViewById(R.id.tvResult)
        val btnRelay: Button = findViewById(R.id.btnCatchCopyReplay)

        val myItem = intent.getStringExtra("MY_ITEM")

        val msgData = arrayOf(
            " 女子高生が選ぶ『 $myItem 』ランキング",
            "100円ショップにあるものだけで『 $myItem 』を作る",
            " 世界の富豪が実践する３つの『 $myItem』",
            " 逆に今『 $myItem 』がナウい！",
            " 世界は『 $myItem 』で出来ている",
            " 彼のハートを打ち抜く神『 $myItem 』",
            " 衝撃！『 $myItem 』だけで１ヵ月生活",
            " あなたの知らない『 $myItem 』の世界",
            " 今からはじめる『 $myItem 』",
            " 乳酸菌が１００億個入った『 $myItem 』",
            " 100年に1度の『 $myItem 』",
            " 愛と『 $myItem 』の物語",
            " 世界よ！これが真の『 $myItem 』だ！！",
            " あのカリスマ『 $myItem 』、待望の映画化！",
            " 今年最高の『 $myItem 』をお届け",
            " あの素晴らしい『 $myItem 』をもう一度",
        )

        val num = Random().nextInt(msgData.size)
        tvResult.text = msgData[num]

        btnRelay.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
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