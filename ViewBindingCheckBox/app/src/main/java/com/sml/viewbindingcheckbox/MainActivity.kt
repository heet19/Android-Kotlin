package com.sml.viewbindingcheckbox

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.sml.viewbindingcheckbox.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            if(binding.checkbox.isChecked) {
                Toast.makeText(this, "Success, Welcome to APP", Toast.LENGTH_SHORT).show()
            } else {
                binding.checkbox.buttonTintList = ColorStateList.valueOf(Color.RED)
                Toast.makeText(this, "Accept t&C", Toast.LENGTH_SHORT).show()
            }
        }

    }
}