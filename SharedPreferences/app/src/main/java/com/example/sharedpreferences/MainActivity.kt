package com.example.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // UI Change
    private lateinit var listener: SharedPreferences.OnSharedPreferenceChangeListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  Get Shared Preference
        val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE)
        binding.email.setText(editor.getString("email", null))
        binding.pass.setText(editor.getString("password", null))

        binding.settingsButton.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        //  Put or Create Shared Preference
        binding.loginIn.setOnClickListener {
            val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE).edit()
            editor.putString("email", binding.email.text.toString())
            editor.putString("password", binding.pass.text.toString())
            editor.apply()

            startActivity(Intent(this, MainActivity2::class.java))

            Toast.makeText(this, "Save to Shared Preferences", Toast.LENGTH_SHORT).show()
        }

        //  UI Change
        val manager = PreferenceManager.getDefaultSharedPreferences(this)
        listener = SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
            if (key.equals("change_UI")) {
                if (manager.getBoolean("change_UI", false)==true)
                    binding.mainLayout.setBackgroundColor(Color.MAGENTA)
                else
                    binding.mainLayout.setBackgroundColor(Color.WHITE)
            }
        }
        manager.registerOnSharedPreferenceChangeListener(listener)
        
        //  Clear Shared Preference
        binding.clearBtn.setOnClickListener {
            val editor = getSharedPreferences("MY_SETTING", MODE_PRIVATE).edit()
            editor.clear()
            editor.apply()

            Toast.makeText(this, "Data removed from Shared Preference", Toast.LENGTH_SHORT).show()
        }
    }
}