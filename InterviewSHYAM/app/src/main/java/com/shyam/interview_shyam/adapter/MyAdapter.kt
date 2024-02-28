package com.shyam.interview_shyam.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shyam.interview_shyam.Model.Item
import com.shyam.interview_shyam.R
import com.shyam.interview_shyam.viewmodel.MyViewModel

class MyAdapter(
    private val viewModel: MyViewModel,
    private var items: List<Item>?,
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private val selectedItems = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items!![position]
        holder.textViewItem.text = item.title
        holder.tvQuantity.text = item.quantity.toString()
        holder.btnPlus.setOnClickListener {
            viewModel.incrementQuantity(item,position)
        }
        holder.btnMinus.setOnClickListener {
            viewModel.decrementQuantity(item,position)
        }

        holder.itemView.setOnClickListener {
            if (selectedItems.contains(item)) {
                selectedItems.remove(item)
                holder.itemView.setBackgroundResource(android.R.color.white)
            } else {
                selectedItems.add(item)
                holder.itemView.setBackgroundResource(android.R.color.darker_gray)
            }
        }
    }

    override fun getItemCount(): Int {
        return items?.size ?: 0
    }

    fun getSelectedItems(): List<Item> {
        return selectedItems
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewItem: TextView = itemView.findViewById(R.id.tvTitle)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
        val btnPlus: Button = itemView.findViewById(R.id.btnPlus)
        val btnMinus: Button = itemView.findViewById(R.id.btnMinus)
    }
}
