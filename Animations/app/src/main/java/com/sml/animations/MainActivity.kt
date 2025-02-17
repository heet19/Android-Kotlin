package com.sml.animations

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val lottieAnimation = findViewById<Button>(R.id.lottieAnimation)
        val animText = findViewById<TextView>(R.id.textView)
        val fade_in = findViewById<Button>(R.id.fade_in)
        val fade_out = findViewById<Button>(R.id.fade_out)
        val rotate = findViewById<Button>(R.id.rotate)
        val zoom_in = findViewById<Button>(R.id.zoom_in)
        val zoom_out = findViewById<Button>(R.id.zoom_out)
        val bounce = findViewById<Button>(R.id.bounce)
        val slide_down = findViewById<Button>(R.id.slide_Down)
        val slide_up = findViewById<Button>(R.id.slide_up)

        lottieAnimation.setOnClickListener {
           val intent = Intent(this, LottieAnimation::class.java)
            startActivity(intent)
        }

        fade_in.setOnClickListener {
            val animationFadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in)
            animText.startAnimation(animationFadeIn)
        }

        fade_out.setOnClickListener {
            val animationFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out)
            animText.startAnimation(animationFadeOut)
        }

        rotate.setOnClickListener {
            val animationRotate = AnimationUtils.loadAnimation(this, R.anim.rotate)
            animText.startAnimation(animationRotate)
        }

        zoom_in.setOnClickListener {
            val animationZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
            animText.startAnimation(animationZoomIn)
        }

        zoom_out.setOnClickListener {
            val animationZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out)
            animText.startAnimation(animationZoomOut)
        }

        bounce.setOnClickListener {
            val animationBounce = AnimationUtils.loadAnimation(this, R.anim.bounce)
            animText.startAnimation(animationBounce)
        }

        slide_down.setOnClickListener {
            val animationSlideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down)
            animText.startAnimation(animationSlideDown)
        }

        slide_up.setOnClickListener {
            val animationSlideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up)
            animText.startAnimation(animationSlideUp)
        }

    }
}