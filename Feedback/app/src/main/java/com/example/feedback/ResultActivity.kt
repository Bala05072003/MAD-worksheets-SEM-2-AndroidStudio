package com.example.feedback

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val txtFeedback = findViewById<TextView>(R.id.txtFeedback)
        val message = intent.getStringExtra("feedback")

        txtFeedback.text = message
    }
}
