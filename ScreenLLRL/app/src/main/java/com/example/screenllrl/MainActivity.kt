package com.example.screenllrl

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.screenllrl.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use ONE layout at a time
       // setContentView(R.layout.activity_main_linear)
        setContentView(R.layout.activity_main_relative)
    }
}
