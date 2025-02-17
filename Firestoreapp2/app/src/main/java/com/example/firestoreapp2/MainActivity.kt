package com.example.firestoreapp2

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firestoreapp2.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var list = arrayListOf<User>()
        var rvAdapter = RvAdapter(this, list)
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = rvAdapter

        val db = Firebase.firestore

        db.collection("users")
            .get()
            .addOnSuccessListener { result ->
                list.clear()
                for (document in result) {
//                    Log.d(TAG, "${document.id} => ${document.data}")
                    var user = document.toObject(User::class.java)
                    user.id = document.id
                    list.add(user)
                }
                rvAdapter.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
//                Log.w(TAG, "Error getting documents.", exception)
            }

    }
}