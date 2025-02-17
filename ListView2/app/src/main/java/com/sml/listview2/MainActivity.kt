package com.sml.listview2

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var userArrayList : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val name = arrayOf("Heet", "Meet", "Harsh", "Jaydeep", "Parth", "Heet", "Meet", "Harsh", "Jaydeep", "Parth", "Heet", "Meet", "Harsh", "Jaydeep", "Parth")

        val lastMsg = arrayOf("Hey everyone", "I am fine", "Good", "Awesome", "cool", "Hey everyone", "I am fine", "Good", "Awesome", "cool", "Hey everyone", "I am fine", "Good", "Awesome", "cool")

        val lastMsgTime = arrayOf("6:25 AM", "7:30 PM", "11:25 AM", "12:45 PM", "8:30 AM", "6:25 AM", "7:30 PM", "11:25 AM", "12:45 PM", "8:30 AM", "6:25 AM", "7:30 PM", "11:25 AM", "12:45 PM", "8:30 AM")

        val phoneNumber = arrayOf("2546318790", "7896318790", "2546312140", "5879518790", "9876318793", "2546318790", "7896318790", "2546312140", "5879518790", "9876318793", "2546318790", "7896318790", "2546312140", "5879518790", "9876318793")

        val imgId = intArrayOf(R.drawable.newsfeed, R.drawable.android, R.drawable.blockchain, R.drawable.dev, R.drawable.ios, R.drawable.newsfeed, R.drawable.android, R.drawable.blockchain, R.drawable.dev, R.drawable.ios, R.drawable.newsfeed, R.drawable.android, R.drawable.blockchain, R.drawable.dev, R.drawable.ios)

        userArrayList = ArrayList()

        for(eachIndex in name.indices) {
            val user = User(name[eachIndex], lastMsg[eachIndex], lastMsgTime[eachIndex], phoneNumber[eachIndex], imgId[eachIndex])

            userArrayList.add(user)
        }

        val listView = findViewById<ListView>(R.id.listView)
        listView.isClickable = true
        listView.adapter = MyAdapater(this, userArrayList)

        listView.setOnItemClickListener { parent, view, position, id ->
            //  open a new activity

            val userName = name[position]
            val userPhone = phoneNumber[position]
            val imageId = imgId[position]

            val i = Intent(this, UserActivity::class.java)

            i.putExtra("name", userName)
            i.putExtra("phone", userPhone)
            i.putExtra("imageId", imageId)
            startActivity(i)

        }

    }
}