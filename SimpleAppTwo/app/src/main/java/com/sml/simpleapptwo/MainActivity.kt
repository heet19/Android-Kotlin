package com.sml.simpleapptwo

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AlertDialogLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sml.simpleapptwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    companion object {
        val KEY = "com.sml.simpleapptwo.MainActivity.KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //  Question 1
        binding.qOne.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Question-1.")
            builder1.setMessage("Are you an Indian?")
            builder1.setIcon(R.drawable.baseline_question_mark_24)
            builder1.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You are an Indian...", Toast.LENGTH_SHORT).show()
            })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "Sad... You are not an Indian.", Toast.LENGTH_SHORT).show()
            })
            builder1.show()
        }

        //  Question 2
        binding.qTwo.setOnClickListener {
            val options = arrayOf("West India", "North India", "East India", "South India")
            val builder2 = AlertDialog.Builder(this)
            builder2.setTitle("Question-2.")
            builder2.setIcon(R.drawable.baseline_question_mark_24)
            builder2.setSingleChoiceItems(options, 0, DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "Wahhh!!! ${options[which]}", Toast.LENGTH_SHORT).show()
            })
            builder2.setPositiveButton("Select", DialogInterface.OnClickListener { dialog, which ->
            })
            builder2.setNeutralButton("Decline", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "Not to Answer...", Toast.LENGTH_SHORT).show()
            })
            builder2.show()
        }


        //  Question 3
        binding.qThree.setOnClickListener {
            val options = arrayOf("Gulab Jamun", "kaju katli", "Laddu", "Rasmallai", "Sukhdi")
            val builder3 = AlertDialog.Builder(this)
            builder3.setTitle("Question-3.")
            builder3.setIcon(R.drawable.baseline_question_mark_24)
            builder3.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this, "Yummy!! ${options[which]}", Toast.LENGTH_SHORT).show()

            })
            builder3.setPositiveButton("Selected", DialogInterface.OnClickListener { dialog, which ->
                // What action should be performed when Accept is clicked

            })
            builder3.setNegativeButton("Rejected", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You don't like Sweets", Toast.LENGTH_SHORT).show()
            })
            builder3.show()
        }

        //  Question 4
        binding.qFour.setOnClickListener {
            val options = arrayOf("Saurashtra", "Kutch", "Gir", "Rameshwaram", "Kashmir")
            val builder4 = AlertDialog.Builder(this)
            builder4.setTitle("Question-4.")
            builder4.setIcon(R.drawable.baseline_question_mark_24)
            builder4.setMultiChoiceItems(options, null, DialogInterface.OnMultiChoiceClickListener { dialog, which, isChecked ->
                Toast.makeText(this, "${options[which]} visited", Toast.LENGTH_SHORT).show()
            })
            builder4.setPositiveButton("Visited", DialogInterface.OnClickListener { dialog, which ->
                // What action should be performed when Accept is clicked

            })
            builder4.setNegativeButton("Not Yet", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You don't visited yet", Toast.LENGTH_SHORT).show()
            })
            builder4.show()
        }

        // CheckBox
        binding.button.setOnClickListener {
            if(binding.checkbox.isChecked) {
                Toast.makeText(this, "Success, Welcome to APP", Toast.LENGTH_SHORT).show()
            } else {
                binding.checkbox.buttonTintList = ColorStateList.valueOf(Color.RED)
                Toast.makeText(this, "Accept t&C", Toast.LENGTH_SHORT).show()
            }
        }

        // Button
        binding.button.setOnClickListener {
            val builder5 = AlertDialog.Builder(this)
            builder5.setTitle("Are you Sure?")
            builder5.setMessage("Do you want to quit Quiz?")
            builder5.setIcon(R.drawable.baseline_exit_to_app_24)
            builder5.setPositiveButton("Quit", DialogInterface.OnClickListener { dialog, which ->

                if (binding.checkbox.isChecked) {
                    Toast.makeText(this, "Exit from Quiz..", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    binding.checkbox.buttonTintList = ColorStateList.valueOf(Color.RED)
                    Toast.makeText(this, "First Submit your Answers", Toast.LENGTH_SHORT).show()
                }
            })
            builder5.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this, "You can continue the Quiz", Toast.LENGTH_SHORT).show()
            })
            builder5.show()
        }

    }
}