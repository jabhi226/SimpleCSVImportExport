package com.example.simplecsvimportexport

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class ReaderAdapter :
    ListAdapter<String, ReaderAdapter.ReaderViewHolder>(object :
        DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }) {
    inner class ReaderViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(item: String?) {
            println("=====> $item")
            view.findViewById<TextView>(R.id.tv_cell).apply {
                text = item
//                movementMethod = ScrollingMovementMethod()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReaderViewHolder {
        return ReaderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_csv_reader, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ReaderViewHolder, position: Int) {
        holder.bindData(getItem(position))
    }
}