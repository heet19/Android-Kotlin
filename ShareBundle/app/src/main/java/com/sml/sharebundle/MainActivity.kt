package com.sml.sharebundle

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val firstName = findViewById<EditText>(R.id.firstName)
        val lastName = findViewById<EditText>(R.id.lastName)
        val rollNo = findViewById<EditText>(R.id.rollNo)
        val phoneNo = findViewById<EditText>(R.id.phoneNo)
        val btnSubmit = findViewById<Button>(R.id.button)

        btnSubmit.setOnClickListener {
            val nameFirst = firstName.text.toString()
            val nameLast = lastName.text.toString()
            val rollNumber = rollNo.text.toString()
            val phoneNumber = phoneNo.text.toString()

            val intent = Intent(this,ProfileActivity::class.java)
            intent.putExtra("first_Name", nameFirst)
            intent.putExtra("last_Name", nameLast)
            intent.putExtra("roll_number", rollNumber)
            intent.putExtra("phone_Number", phoneNumber)
            startActivity(intent)
        }

    }
}