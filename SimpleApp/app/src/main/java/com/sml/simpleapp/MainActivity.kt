package com.sml.simpleapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val welcomeBtn = findViewById<Button>(R.id.btnWecome)

        welcomeBtn.setOnClickListener {
            intent = Intent(applicationContext, CardViewActivity::class.java)
            startActivity(intent)
        }

    }
}