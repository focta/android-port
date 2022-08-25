package jp.tm.touchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondPutExtraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_put_extra)

        val tvName: TextView = findViewById(R.id.tvName)
        val btnBack: Button = findViewById(R.id.btnBack2)

        val myName = intent.getStringExtra("MY_NAME")
        tvName.text = myName + "さん"

        btnBack.setOnClickListener {
            finish()
        }
    }
}