package com.sml.splashscreen

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreenWithLoadingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen_with_loading)

        startHeavyTask()
    }

    private fun startHeavyTask() {
        LongOperation().execute()

    }

    private open inner class LongOperation : AsyncTask<String?, Void?, String?>() {
        override fun doInBackground(vararg params: String?): String? {
            for (i in 0..6){
                try {
                    Thread.sleep(1000)
                } catch (e:Exception) {
                    Thread.interrupted()
                }
            }
            return "result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)

            startActivity(Intent(this@SplashScreenWithLoadingActivity, MainActivity::class.java))
        }

    }
}