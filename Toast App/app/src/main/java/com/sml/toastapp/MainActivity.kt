package com.sml.toastapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.shashank.sony.fancytoastlib.FancyToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /** Fency Toast
            Search "fency Toast github" in google
            add Dependency    */

        val defaultToast = findViewById<Button>(R.id.defaultToast)
        val fencySuccessToast = findViewById<Button>(R.id.fencySuccessToast)
        val fencyDefault = findViewById<Button>(R.id.fencyDefault)
        val fencyInfoToast = findViewById<Button>(R.id.fencyInfoToast)
        val fencyWarningToast = findViewById<Button>(R.id.fencyWarningToast)
        val fencyErrorToast = findViewById<Button>(R.id.fencyErrorToast)
        val fencyConfusingToast = findViewById<Button>(R.id.fencyConfusingToast)
        val fencyCustomWithVectorIcon =findViewById<Button>(R.id.fencyToastwithVectorIcon)

        defaultToast.setOnClickListener {
            Toast.makeText(this, "Android Stdio Default Toast...", Toast.LENGTH_SHORT).show()
        }

        fencySuccessToast.setOnClickListener{
            FancyToast.makeText(this,"I am Success Toast! 😍", FancyToast.LENGTH_LONG, FancyToast.SUCCESS,false).show()
        }

        fencyDefault.setOnClickListener {
            FancyToast.makeText(this,"I am Default Toast! 😍", FancyToast.LENGTH_LONG, FancyToast.DEFAULT,true).show()
        }

        fencyInfoToast.setOnClickListener {
            FancyToast.makeText(this,"I am Info Toast!", FancyToast.LENGTH_LONG, FancyToast.INFO,true).show()
        }

        fencyWarningToast.setOnClickListener {
            FancyToast.makeText(this,"I am Warning Toast!", FancyToast.LENGTH_LONG, FancyToast.WARNING,true).show()
        }

        fencyErrorToast.setOnClickListener {
            FancyToast.makeText(this,"I am Error Toast!", FancyToast.LENGTH_LONG, FancyToast.ERROR,true).show()
        }

        fencyConfusingToast.setOnClickListener {
            FancyToast.makeText(this,"I am Confusing Toast!", FancyToast.LENGTH_LONG, FancyToast.CONFUSING,true).show()
        }

        fencyCustomWithVectorIcon.setOnClickListener {
            FancyToast.makeText(this, "Toast with Vector Icon", FancyToast.LENGTH_LONG, FancyToast.CONFUSING, R.drawable.baseline_person_24, false).show()
        }
    }
}