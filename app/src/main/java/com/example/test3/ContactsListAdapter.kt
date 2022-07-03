package com.example.test3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactsListAdapter(private val itemList : List<Contacts>) : RecyclerView.Adapter<ContactsViewHolder>()  {

    // number of items in list
    override fun getItemCount(): Int {
        return itemList.size
    }

    // connect to item layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_contacts, parent, false)
        return ContactsViewHolder(inflatedView)
    }

    // put content inside the view
    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        val item = itemList[position]

        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
        holder.itemView.setOnLongClickListener {
            itemLongClickListener.onLongClick(it, position)
        }
        holder.apply {
            bind(item)
        }
    }

    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    private lateinit var itemClickListener: OnItemClickListener
    fun setItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }

    interface  OnItemLongClickListener {
        fun onLongClick(v: View, position: Int): Boolean
    }
    private lateinit var itemLongClickListener: OnItemLongClickListener
    fun setItemLongClickListener(itemLongClickListener: OnItemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener
    }
}