package com.sml.fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sml.fragments.databinding.ActivityMainBinding
import com.sml.fragments.fragments.BlankFragment1
import com.sml.fragments.fragments.BlankFragment2

class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

//        var manager = supportFragmentManager    //  support of Frame Manager
//        var tr = manager.beginTransaction()     //  start Transaction
//        tr.replace(R.id.frame, BlankFragment1())    //  what Transaction
//        tr.commit()

        binding.button1.setOnClickListener {
            var manager = supportFragmentManager    //  support of Frame Manager
            var tr = manager.beginTransaction()     //  start Transaction
            tr.replace(R.id.frame, BlankFragment1())    //  what Transaction
            tr.commit()     //  final done
        }

        binding.button2.setOnClickListener {
            var manager = supportFragmentManager    //  support of Frame Manager
            var tr = manager.beginTransaction()     //  start Transaction
            tr.replace(R.id.frame, BlankFragment2())    //  what Transaction
            tr.commit()     //  final done
        }

    }
}