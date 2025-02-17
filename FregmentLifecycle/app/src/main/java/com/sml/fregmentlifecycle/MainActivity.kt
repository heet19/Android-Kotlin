package com.sml.fregmentlifecycle

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val openFregmant = findViewById<Button>(R.id.button)
        openFregmant.setOnClickListener {
            val fregment = BlankFragment()

            val transient : FragmentTransaction = supportFragmentManager.beginTransaction()
            transient.replace(R.id.frameLayout, fregment)
            transient.addToBackStack(null)
            transient.commit()
        }

    }
}