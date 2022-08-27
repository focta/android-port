package jp.tm.touchapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GameClearActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_clear)

        val btnReplay: Button = findViewById(R.id.btnClearReplay)

        btnReplay.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            // 遷移後にゲーム状態の初期化のためにMainActivityの処理をonCreateから呼び出したい
            // そのためstartActivityで呼び出して自身を終了させる
            startActivity(intent)
            finish()
        }
    }
}