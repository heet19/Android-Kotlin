package com.sml.datapass

import android.content.Intent
import android.os.Bundle
 import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    //  creating key
    companion object{
        val KEY = "com.sml.datapass.MainActivity.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eT1 = findViewById<EditText>(R.id.eT1)
        val eT2 = findViewById<EditText>(R.id.eT2)
        val eT3 = findViewById<EditText>(R.id.eT3)
        val eT4 = findViewById<EditText>(R.id.eT4)
        val btnOrder = findViewById<Button>(R.id.button)

        btnOrder.setOnClickListener {
            val ordersPlaced = eT1.text.toString() + " " + eT2.text.toString() + " " + eT3.text.toString() + " " + eT4.text.toString()

            intent = Intent(this, Order::class.java)
            intent.putExtra(KEY, ordersPlaced)
            startActivity(intent)
        }

    }
}