package com.sml.fregmentlifecycle

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


class BlankFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TAG", "onAttach: View Created")
        Toast.makeText(requireContext(), "onAttach: View Created", Toast.LENGTH_SHORT).show()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d ("TAG", "onCreate: View Created")
        Toast.makeText(requireContext(), "onCreate: View Created", Toast.LENGTH_SHORT).show()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
        Log.d("TAG", "onCreateView: View Created")
        Toast.makeText(requireContext(), "onCreateView: View Created", Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG", "onViewCreated: View Created")
        Toast.makeText(requireContext(), "onViewCreated: View Created", Toast.LENGTH_SHORT).show()

    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d("TAG", "onViewStateRestored: View Created")
        Toast.makeText(requireContext(), "onViewStateRestored: View Created", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "onStart: View Created")
        Toast.makeText(requireContext(), "onStart: View Created", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: View Created")
        Toast.makeText(requireContext(), "onResume: View Created", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause: View Created")
        Toast.makeText(requireContext(), "onPause: View Created", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop: View Created")
        Toast.makeText(requireContext(), "onStop: View Created", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TAG", "onDestroyView: View Created")
        Toast.makeText(requireContext(), "onDestroyView: View Created", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDetach: View Created")
        Toast.makeText(requireContext(), "onDetach: View Created", Toast.LENGTH_SHORT).show()
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("TAG", "onDetach: View Created")
        Toast.makeText(requireContext(), "onDetach: View Created", Toast.LENGTH_SHORT).show()
    }

}