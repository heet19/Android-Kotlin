package com.sml.contactapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseReference
import com.sml.contactapp.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding

    lateinit var database :DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignUp.setOnClickListener {

            val name = binding.etName.text.toString()
            val phone = binding.etPhone.text.toString()
            val mail = binding.etMail.text.toString()
            val uniqueId = binding.etUniqueId.text.toString()
            val password = binding.etPassword.text.toString()

            if(name.isNotEmpty() && phone.isNotEmpty() && mail.isNotEmpty() && uniqueId.isNotEmpty() && password.isNotEmpty()) {

                val name =  binding.etName.text.toString()
                val phone =  binding.etPhone.text.toString()
                val mail =  binding.etMail.text.toString()
                val uniqueId =  binding.etUniqueId.text.toString()
                val password =  binding.etPassword.text.toString()

                val user = User(name, phone, mail, uniqueId, password)
                database = FirebaseDatabase.getInstance().getReference("Users")

                database.child(phone).setValue(user).addOnSuccessListener {

                    binding.etName.text?.clear()
                    binding.etPhone.text?.clear()
                    binding.etMail.text?.clear()
                    binding.etUniqueId.text?.clear()
                    binding.etPassword.text?.clear()

                    Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()

                    val openMainActivity = Intent(this, MainActivity::class.java)
                    startActivity(openMainActivity)
                    finishAffinity()

                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }

            } else {
                Toast.makeText(this, "Please enter all details", Toast.LENGTH_SHORT).show()
            }

        }

        binding.tvSignIn.setOnClickListener{
            val openSignInActivity = Intent(this, SignInActivity::class.java)
            startActivity(openSignInActivity)
        }
    }
}