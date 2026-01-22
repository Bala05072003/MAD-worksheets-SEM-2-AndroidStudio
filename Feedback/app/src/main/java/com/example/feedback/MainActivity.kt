package com.example.feedback

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ratingBar = findViewById<RatingBar>(R.id.ratingBar)
        val txtRatingMsg = findViewById<TextView>(R.id.txtRatingMsg)
        val edtFeedback = findViewById<EditText>(R.id.edtFeedback)
        val btnSend = findViewById<Button>(R.id.btnSend)

        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            txtRatingMsg.text = when (rating.toInt()) {
                5 -> "Awesome. I love it"
                4 -> "Good. Enjoyed it"
                3 -> "Satisfied"
                2 -> "Not good. Need improvement"
                1 -> "Disappointed. Very poor"
                else -> ""
            }
        }

        btnSend.setOnClickListener {
            val message = edtFeedback.text.toString()

            if (message.isEmpty()) {
                edtFeedback.error = "Message is required"
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("feedback", message)
                startActivity(intent)
            }
        }
    }
}
