package com.shyam.interview_shyam.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shyam.interview_shyam.Model.Data
import com.shyam.interview_shyam.R

class Task1Adapter(private val context: Context, private val dataList: List<Data>) :
    RecyclerView.Adapter<Task1Adapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task1, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]

        Glide.with(context).load(data.profile).into(holder.imageView)
        holder.nameTextView.text = data.name
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.img)
        val nameTextView: TextView = itemView.findViewById(R.id.title)
    }
}