package com.sml.themechangeapp

import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonLight = findViewById<Button>(R.id.btnLight)
        val buttonDark = findViewById<Button>(R.id.btnDark)
        val buttonRead = findViewById<Button>(R.id.btnRead)
        val layout = findViewById<LinearLayout>(R.id.main)

        buttonLight.setOnClickListener {
            // Change to light mode
            layout.setBackgroundResource(R.color.white)
        }

        buttonDark.setOnClickListener {
            // Change to dark mode
            layout.setBackgroundResource(R.color.black)
        }

        buttonRead.setOnClickListener {
            // Change to read mode
            layout.setBackgroundResource(R.color.yellow)
        }
    }
}