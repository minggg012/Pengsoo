package com.example.test3

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_extra.view.*

class ExtraViewHolder(v: View): RecyclerView.ViewHolder(v) {
    var view: View = v

    fun bind(item: ExtraEntry) {
        view.mEntry.setImageResource(R.drawable.ic_baseline_person_24)
    }
}