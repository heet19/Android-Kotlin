package com.sml.fragments.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.sml.fragments.R
import com.sml.fragments.databinding.FragmentBlank1Binding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BlankFragment1 : Fragment() {

    private lateinit var binding: FragmentBlank1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank1Binding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    companion object {

    }
}