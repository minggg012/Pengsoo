package com.example.test3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class GalleryAdapter(private val imagesPhoto: List<GalleryFragment.Images>) :
    RecyclerView.Adapter<GalleryViewHolder>() {

    override fun getItemCount(): Int {
        return imagesPhoto.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_gallery, parent, false)
        return GalleryViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val item = imagesPhoto[position]
        val adapter = this


        holder.imagee.setImageResource(item.image)
        holder.itemView.setOnClickListener {
            itemClickListener.onClick(it, position)
        }
//        holder.itemView.setOnLongClickListener {
//            longClickListener.onLongClick(it, position)
//        }

    }
    interface OnItemClickListener {
        fun onClick(v: View, position: Int)
    }
    private lateinit var itemClickListener : OnItemClickListener

    fun setItemClickListener(itemClickListener: OnItemClickListener) {
        this.itemClickListener = itemClickListener
    }
    interface OnItemLongClickListener {
        fun onLongClick(v: View, position: Int): Boolean
    }
    private lateinit var longClickListener : OnItemLongClickListener

    fun setItemLongClickListener(longClickListener: OnItemLongClickListener) {
        this.longClickListener = longClickListener
    }


}