package com.example.getdatausingvolley

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class Adapter(val context:Context, val UserInfo: UserInfo): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view =LayoutInflater.from(context).inflate(R.layout.single_row,parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return UserInfo.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        Glide.with(context).load(UserInfo.get(position).avatar_url).into(holder.userImage)
        holder.userName.text = UserInfo.get(position).login

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val userImage = itemView.findViewById<ImageView>(R.id.imageView)
        val userName = itemView.findViewById<TextView>(R.id.textView)

    }

}