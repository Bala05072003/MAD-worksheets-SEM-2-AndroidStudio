package com.example.form_design

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val tv = findViewById<TextView>(R.id.tvDetails)
        tv.text = intent.getStringExtra("details")
    }
}
