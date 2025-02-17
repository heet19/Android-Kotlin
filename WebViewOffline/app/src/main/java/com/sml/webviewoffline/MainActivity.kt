package com.sml.webviewoffline

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.sml.webviewoffline.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.webView.loadUrl("file:///android_asset/portfolio/index.html")
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()

    }
}