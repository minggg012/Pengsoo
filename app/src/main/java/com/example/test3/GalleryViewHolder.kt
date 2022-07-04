package com.example.test3

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class GalleryViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    private var view : View = v

    val imagee: ImageView = view.findViewById(R.id.mImage)

        fun bind(onClickListner: View.OnClickListener) {
            view.setOnClickListener(onClickListner)
        }





//        fun bind(item: Images) {
//            view.mimage.imageAlpha= item.image
//        }
}