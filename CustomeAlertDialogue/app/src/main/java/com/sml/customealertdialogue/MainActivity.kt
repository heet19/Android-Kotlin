package com.sml.customealertdialogue

import android.app.Dialog
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //  create a variable of type Dialog
    lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var myButton = findViewById<Button>(R.id.btnClick)


        dialog = Dialog(this)
        dialog.setContentView(R.layout.custom_dialogue)
        dialog.window?.setBackgroundDrawable(getDrawable(R.drawable.bg_alert_box))

        //  creating variable for the custom_dialogue.xml design

        var buttonGood = dialog.findViewById<Button>(R.id.btnGood)
        var buttonFeedback = dialog.findViewById<Button>(R.id.btnFeedback)

        buttonGood.setOnClickListener {
            dialog.dismiss()
        }

        buttonFeedback.setOnClickListener {
            Toast.makeText(this, "Thank you for feedback...", Toast.LENGTH_SHORT).show()
        }

        myButton.setOnClickListener {
            dialog.show()
        }

    }
}