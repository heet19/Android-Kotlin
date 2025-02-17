package com.sml.loginandsignupwithfirebase

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sml.loginandsignupwithfirebase.databinding.ActivityLogInBinding
import com.sml.loginandsignupwithfirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.createNotesButton.setOnClickListener {
            startActivity(Intent(this, AddNote::class.java))
            finish()
        }

        binding.openNoteButton.setOnClickListener {
            startActivity(Intent(this, AllNotes::class.java))
            finish()
        }

    }
}