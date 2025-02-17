package com.sml.photoframeapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    lateinit var image : ImageView
    var names = arrayOf("AI/ML", "Dev Ops", "Blockchain", "iOS")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val prev = findViewById<ImageButton>(R.id.imgPrev)
        val next = findViewById<ImageButton>(R.id.imgNext)
        val text = findViewById<TextView>(R.id.textView)

        prev.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            //  convert string id into integer associated with it
            val idCurrenntImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrenntImageInt)
            image.alpha = 0f

            currentImage = (4 + currentImage - 1) % 4

            val idImageToShowString = "pic$currentImage"
            //  convert string id into integer associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            text.text = names[currentImage]
        }

        next.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            //  convert string id into integer associated with it
            val idCurrenntImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image = findViewById(idCurrenntImageInt)
            image.alpha = 0f

            currentImage = (4 + currentImage +  1) % 4

            val idImageToShowString = "pic$currentImage"
            //  convert string id into integer associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image = findViewById(idImageToShowInt)
            image.alpha = 1f

            text.text = names[currentImage]
        }
    }
}