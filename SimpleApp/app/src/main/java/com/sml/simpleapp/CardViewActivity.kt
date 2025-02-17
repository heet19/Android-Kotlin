package com.sml.simpleapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CardViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_card_view)

        val cardOne = findViewById<CardView>(R.id.cardOne)
        val cardTwo = findViewById<CardView>(R.id.cardTwo)
        val cardThree = findViewById<CardView>(R.id.cardThree)
        val cardFour = findViewById<CardView>(R.id.cardFour)
        val cardFive = findViewById<CardView>(R.id.cardFive)
        val cardSix = findViewById<CardView>(R.id.cardSix)
        val btnCall = findViewById<Button>(R.id.btnCall)

        cardOne.setOnClickListener {
            intent = Intent(this, CardOneActivity::class.java)
            startActivity(intent)
        }

        cardTwo.setOnClickListener {
            intent = Intent(this, CardTwoActivity::class.java)
            startActivity(intent)
        }

        cardThree.setOnClickListener {
            intent = Intent(this, CardThreeActivity::class.java)
            startActivity(intent)
        }

        cardFour.setOnClickListener {
            intent = Intent(this, CardFourActivity::class.java)
            startActivity(intent)
        }

        cardFive.setOnClickListener {
            intent = Intent(this, CardFiveActivity::class.java)
            startActivity(intent)
        }

        cardSix.setOnClickListener {
            intent = Intent(this, CardSixActivity::class.java)
            startActivity(intent)
        }

        btnCall.setOnClickListener {
            val phoneNumber = "1234567890" // Replace with the desired phone number
            val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialIntent)
        }


    }
}