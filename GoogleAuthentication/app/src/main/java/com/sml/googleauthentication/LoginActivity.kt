package com.sml.googleauthentication

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sml.googleauthentication.databinding.ActivityLoginBinding
import com.sml.googleauthentication.databinding.ActivityWelcomeBinding

class LoginActivity : AppCompatActivity() {

    private val binding: ActivityLoginBinding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        val loginSignUpText = "Don't have an account ? Sign Up"
        val spannableString = SpannableString(loginSignUpText)
        spannableString.setSpan(ForegroundColorSpan(Color.parseColor("#103D78")),24,loginSignUpText.length,0)

        binding.loginSignupText.text = spannableString

        binding.loginBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.loginSignupText.setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
            finish()
        }
    }
}