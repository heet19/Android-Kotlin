package com.sml.sharebundle

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        val firstName = findViewById<TextView>(R.id.show_first_name)
        val lastName = findViewById<TextView>(R.id.show_last_name)
        val rollNo = findViewById<TextView>(R.id.show_roll_no)
        val phoneNo = findViewById<TextView>(R.id.show_phone_no)

        val intent = intent
        val firstNames = intent.getStringExtra("first_Name")
        val lastNames = intent.getStringExtra("last_Name")
        val rollNos = intent.getStringExtra("roll_number")
        val phoneNos = intent.getStringExtra("phone_Number")

        firstName.text = "First Name: $firstNames"
        lastName.text = "Last Name: $lastNames"
        rollNo.text = "Roll no.: $rollNos"
        phoneNo.text = "Phone no.: $phoneNos"
    }
}