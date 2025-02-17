package com.sml.alertdialogue

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sml.alertdialogue.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you Sure?")
            builder1.setMessage("Do you want to close app?")
            builder1.setIcon(R.drawable.baseline_exit_to_app_24)
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                // What action should be performed when Yes is clicked
                finish()
            })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                // What action should be performed when No is clicked

            })
            builder1.show()
        }

        binding.btn2.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "kaju katli", "Laddu", "Rasmallai")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Which is your favourite sweet?")
            builder2.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener { dialog, which ->
                // What action should be performed when user clicks on any Option
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Accept", DialogInterface.OnClickListener { dialog, which ->
                // What action should be performed when Accept is clicked
            })
            builder2.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->
                // What action should be performed when Decline is clicked
            })
            builder2.show()
        }

        binding.btn3.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "kaju katli", "Laddu", "Rasmallai")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Which is your favourite sweet?")
            builder3.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this, "You clicked on ${options[which]}", Toast.LENGTH_SHORT).show()
            })

            builder3.setPositiveButton("Accept", DialogInterface.OnClickListener { dialog, which ->
                // What action should be performed when Accept is clicked
            })
            builder3.setNegativeButton("Decline", DialogInterface.OnClickListener { dialog, which ->
                // What action should be performed when Decline is clicked
            })
            builder3.show()
        }

    }
}