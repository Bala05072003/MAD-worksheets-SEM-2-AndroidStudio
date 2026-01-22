package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etFahrenheit = findViewById<EditText>(R.id.etFahrenheit)
        val etCelsius = findViewById<EditText>(R.id.etCelsius)
        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnConvert.setOnClickListener {
            val fText = etFahrenheit.text.toString()
            val cText = etCelsius.text.toString()

            if (fText.isNotEmpty()) {
                val fahrenheit = fText.toDouble()
                val celsius = (fahrenheit - 32) * 5 / 9
                tvResult.text = "Celsius: %.2f".format(celsius)
            }
            else if (cText.isNotEmpty()) {
                val celsius = cText.toDouble()
                val fahrenheit = (celsius * 9 / 5) + 32
                tvResult.text = "Fahrenheit: %.2f".format(fahrenheit)
            }
            else {
                tvResult.text = "Please enter a value"
            }
        }
    }

    private fun findViewById(etFahrenheit: Int) {}
}
