package com.sml.contactapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.sml.contactapp.databinding.ActivityMainBinding
import com.sml.contactapp.databinding.ActivitySignInBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the phone number of the logged-in user (use phone number as unique identifier)
        val phoneNumber = intent.getStringExtra("phone") ?: ""

        if (phoneNumber.isNotEmpty()) {
            // Initialize Firebase Database reference
            databaseReference = FirebaseDatabase.getInstance().getReference("Users")

            // Retrieve user data from Firebase using phone number as key
            getUserData(phoneNumber)
        } else {
            Toast.makeText(this, "User not logged in", Toast.LENGTH_SHORT).show()
        }
    }

    private fun getUserData(phone: String) {
        databaseReference.child(phone).addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    // Retrieve user data from Firebase
                    val user = snapshot.getValue(User::class.java)

                    // If user data is retrieved, display it
                    if (user != null) {
                        binding.tvName.text = "Name: ${user.name}"
                        binding.tvMail.text = "Email: ${user.email}"
                        binding.tvPhone.text = "Phone: ${user.phone}"
                        binding.tvUnique.text = "Unique ID: ${user.uniqueId}"
                    }
                } else {
                    Toast.makeText(this@MainActivity, "User data not found", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Failed to load data: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

}