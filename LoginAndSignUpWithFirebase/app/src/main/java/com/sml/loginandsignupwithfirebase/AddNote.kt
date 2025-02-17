package com.sml.loginandsignupwithfirebase

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.sml.loginandsignupwithfirebase.databinding.ActivityAddNoteBinding

class AddNote : AppCompatActivity() {

    private val binding : ActivityAddNoteBinding by lazy {
        ActivityAddNoteBinding.inflate(layoutInflater)
    }

    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        //  Initialize Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().reference
        auth = FirebaseAuth.getInstance()

        binding.saveNoteButton.setOnClickListener {

            //  get text from edit text
            val title = binding.eTTitle.text.toString()
            val description = binding.eTDescription.text.toString()

            if (title.isEmpty() && description.isEmpty()) {
                Toast.makeText(this, "Fill both Fields", Toast.LENGTH_SHORT).show()
            } else {
                val currentUser = auth.currentUser
                currentUser?. let { user ->
                    //  Generate a unique Key for the Note
                    val noteKey = databaseReference.child("users").child(user.uid).child("notes").push().key

                    //  note item instance
                    val noteItem = NoteItem(title,description, noteKey ?: "")
                    if (noteKey!=null)
                        //  add notes to the user note
                        databaseReference.child("users").child(user.uid).child("notes").child(noteKey).setValue(noteItem)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful){
                                    Toast.makeText(this, "Note Save Successful", Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(this, AllNotes::class.java))
                                    finish()
                                } else{
                                    Toast.makeText(this, "Failed to Save Note", Toast.LENGTH_SHORT).show()
                                }
                            }
                }
            }

        }

    }
}