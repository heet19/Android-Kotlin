package com.example.sharedpreferences

import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferences.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //  Get Shared Preference
        val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.textView.setText("E-mail: ${editor.getString("email", null)}" + "Password: ${editor.getString("password", null)}")

        Toast.makeText(this, "Get from Shared Preferences", Toast.LENGTH_SHORT).show()

    }
}