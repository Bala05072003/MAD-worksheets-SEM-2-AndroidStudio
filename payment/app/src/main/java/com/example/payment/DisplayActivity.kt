package com.example.payment

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.payment.R

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val tv = findViewById<TextView>(R.id.tvResult)

        tv.text = """
            Card Type: ${intent.getStringExtra("cardType")}
            Card Number: ${intent.getStringExtra("cardNumber")}
            Expiry Date: ${intent.getStringExtra("expiry")}
            CVV: ${intent.getStringExtra("cvv")}
            Address: ${intent.getStringExtra("address")}
            City: ${intent.getStringExtra("city")}
            Country: ${intent.getStringExtra("country")}
        """.trimIndent()
    }
}
