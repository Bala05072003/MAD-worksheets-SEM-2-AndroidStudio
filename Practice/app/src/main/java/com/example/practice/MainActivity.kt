package com.example.practice

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val x = findViewById<Button>(R.id.b1)
        val y = findViewById<Button>(R.id.b2)
        val z =findViewById<TextView>(R.id.t1)

        x.setOnClickListener(View.OnClickListener {
            z.text = "PSG Tech"
        })

    }

    fun fun1(v:View)
    {
        Toast.makeText(applicationContext,"MCA G1",Toast.LENGTH_SHORT).show()
    }

}