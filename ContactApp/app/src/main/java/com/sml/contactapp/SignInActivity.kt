package com.sml.contactapp

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sml.contactapp.databinding.ActivitySignInBinding
import com.sml.contactapp.databinding.ActivitySignUpBinding

class SignInActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignInBinding

    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignIn.setOnClickListener {

            val phone = binding.signInPhone.text.toString()
            if(phone.isNotEmpty()) {
                readData(phone)
            } else {
                Toast.makeText(this, "Please enter user id", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun readData(phone: String) {

        databaseReference = FirebaseDatabase.getInstance().getReference("Users")

        databaseReference.child(phone).get().addOnSuccessListener {

            if (it.exists()) {
                val intentWelcome = Intent(this, MainActivity::class.java)
                startActivity(intentWelcome)
                finishAffinity()
            } else{
                Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
            }

            }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
            }
        }

}
