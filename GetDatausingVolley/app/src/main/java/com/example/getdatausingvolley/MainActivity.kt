package com.example.getdatausingvolley

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    var apiUrl = "https://api.github.com/users"
    private var UserInfoItem = arrayOf<UserInfoItem>()
    var UserInfor = UserInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val recyclerView =findViewById<RecyclerView>(R.id.rev)

        val stringRequest = StringRequest(apiUrl, Response.Listener {

            val gsonB = GsonBuilder()
            val gson = gsonB.create()
            UserInfoItem = gson.fromJson(it, Array<UserInfoItem>::class.java)

            UserInfoItem.forEach {
                UserInfor.add(it)
            }

//            Toast.makeText(this@MainActivity, UserInfor.toString(), Toast.LENGTH_LONG).show()


            val adapter = Adapter(this, UserInfor)
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter


        }, Response.ErrorListener {
            Toast.makeText(this@MainActivity, "Something went wrong" + it.toString(), Toast.LENGTH_LONG).show()
        })


        val volleyQueue = Volley.newRequestQueue(this)
        volleyQueue.add(stringRequest)

    }

}


/**
 * Volley API
 *
 * step 1 -> add the Dependency in gradleBuild
 * step 2 -> add Internet Permission in Manifest.xml
 * step 3 -> create Model/Data class
 * step 4 -> Do code in MainActivity.kt
 */