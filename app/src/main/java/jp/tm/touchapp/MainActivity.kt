package jp.tm.touchapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Debug", "onCreate()")

        val apiKey = "ce6aca55bfda056ef598d23a44cb8a53"
        val mainUrl = "https://api.openweathermap.org/data/2.5/weather?lang=ja"

        val btnTokyo: Button = findViewById(R.id.btnTokyo)
        val btnOkinawa: Button = findViewById(R.id.btnOkinawa)
        val tvCityName: TextView = findViewById(R.id.tvCityName)
        val tvCityWeather: TextView = findViewById(R.id.tvCityWeather)
        val tvMaxTemperature: TextView = findViewById(R.id.tvMaxTemperature)
        val tvMinTemperature: TextView = findViewById(R.id.tvMinTemperature)

        btnTokyo.setOnClickListener {
            // URLはこちら
            // https://api.openweathermap.org/data/2.5/weather?lang=ja&q=tokyo&appid=ce6aca55bfda056ef598d23a44cb8a53
            val weatherUrl = "$mainUrl&q=tokyo&appid=$apiKey"

            // Coroutineの実行
            weatherTask(weatherUrl)

        }

        btnOkinawa.setOnClickListener {
            val weatherUrl = "$mainUrl&q=okinawa&appid=$apiKey"

            // Coroutineの実行
            weatherTask(weatherUrl)

        }
    }

    private fun weatherTask(weatherUrl: String) {
        lifecycleScope.launch {
            val result = weatherBackgroundTask(weatherUrl)
            Log.d("Debug", result)

            weatherJsonTask(result)
        }
    }

    private suspend fun weatherBackgroundTask(weatherUrl: String):String {
        val response = withContext(Dispatchers.IO) {
            var httpResult = ""
            try {
                val urlObj = URL(weatherUrl)
                val br =BufferedReader(InputStreamReader(urlObj.openStream()))
                httpResult = br.readText()
            } catch(e: IOException) {
                e.printStackTrace()
            }
            return@withContext httpResult
        }
        return response
    }

    private fun weatherJsonTask(result: String) {
        val tvCityName: TextView = findViewById(R.id.tvCityName)
        val tvCityWeather: TextView = findViewById(R.id.tvCityWeather)
        val tvMaxTemperature: TextView = findViewById(R.id.tvMaxTemperature)
        val tvMinTemperature: TextView = findViewById(R.id.tvMinTemperature)

        val jsonObj = JSONObject(result)
        val cityName = jsonObj.getString("name")
        val weatherJsonArray = jsonObj.getJSONArray("weather")
        val weatherJson = weatherJsonArray.getJSONObject(0)
        val weather = weatherJson.getString("description")
        tvCityWeather.text = weather

        // Jsonデータの気温が絶対温度(ケルビン)表記なので、-273を行うことで摂氏の表記に戻す
        val main = jsonObj.getJSONObject("main")
        tvMaxTemperature.text = "最高気温: ${main.getInt("temp_max") - 273}"
        tvMinTemperature.text = "最低気温: ${main.getInt("temp_min") - 273}"

        tvCityName.text = cityName
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