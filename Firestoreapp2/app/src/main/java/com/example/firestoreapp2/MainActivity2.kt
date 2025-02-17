package com.example.firestoreapp2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.firestoreapp2.databinding.ActivityMain2Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = Firebase.firestore

        binding.nameupdate.setText(intent.getStringExtra("NAME"))
        binding.passupdate.setText(intent.getStringExtra("PASS"))

        binding.updatebtn.setOnClickListener {
            val user = hashMapOf(
                "name" to binding.nameupdate.text.toString(),
                "pass" to binding.passupdate.text.toString()
            )
            db.collection("users").document(intent.getStringExtra("ID")!!).set(user)
            finish()
        }

    }
}