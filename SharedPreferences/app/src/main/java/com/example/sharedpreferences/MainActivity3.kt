package com.example.sharedpreferences

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.sharedpreferences.databinding.ActivityMain3Binding

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val editor = getPreferences(MODE_PRIVATE)

        binding.name.setText(editor.getString("name", null))
        binding.checkBox.isChecked = editor.getBoolean("checked", false)

        binding.save.setOnClickListener {
            val editor = getPreferences(MODE_PRIVATE).edit()
            editor.putString("name", binding.name.text.toString())
            editor.putBoolean("checked", binding.checkBox.isChecked)
            editor.apply()

            Toast.makeText(this, "Save to Shared Preferences", Toast.LENGTH_SHORT).show()
        }

    }
}