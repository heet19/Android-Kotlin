package com.sml.menu

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val customMenu = com.sml.menu.CustomMenu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val showPopUp = findViewById<Button>(R.id.button)

        showPopUp.setOnClickListener {
            customMenu.customeMenu(this, it)
        }
    }
}