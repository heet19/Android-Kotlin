package com.sml.activitylifecycle

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("TAG", "onCreate: I am Running")
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show()

    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "onStart: I am Running")
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: I am Running")
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause: I am Running")
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop: I am Running")
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAG", "onRestart: I am Running")
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy: I am Running")
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()    }
}