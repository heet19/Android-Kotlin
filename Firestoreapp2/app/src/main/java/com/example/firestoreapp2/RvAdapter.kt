package com.example.firestoreapp2

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firestoreapp2.databinding.RvItemBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RvAdapter(var context: Context, var list: ArrayList<User>):
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    class ViewHolder(var binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.name.text = list.get(position).name
        holder.binding.pass.text = list.get(position).pass

        holder.binding.update.setOnClickListener {
            var intent = Intent(context, MainActivity2::class.java)
            intent.putExtra("NAME", list.get(position).name)
            intent.putExtra("PASS", list.get(position).pass)
            intent.putExtra("ID", list.get(position).id)
            context.startActivity(intent)
        }

        holder.binding.delete.setOnClickListener {
            val db = Firebase.firestore
            db.collection("users").document(list.get(position).id!!).delete().addOnSuccessListener {
                Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()

                list.removeAt(position)
                notifyDataSetChanged()

            }.addOnFailureListener {
                Toast.makeText(context, "Failed to delete", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}