package com.example.test3

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_extra.view.*

class ExtraViewHolder(v: View): RecyclerView.ViewHolder(v) {
    var view: View = v

    fun bind(item: ExtraEntry) {
        if (item.isCovered) { // not covered

        }
        else if (item.isFlag) { // flag 표시
            view.mEntry.setImageResource(R.drawable.a)
        }
        else { // covered
            val index = item.numOfMine
            when(index) {
                -1 -> view.mEntry.setImageResource(R.drawable.b)
                0 -> view.mEntry.setImageResource(R.drawable.c)
                1 -> view.mEntry.setImageResource(R.drawable.one)
                2 -> view.mEntry.setImageResource(R.drawable.two)
                3 -> view.mEntry.setImageResource(R.drawable.three)
                4 -> view.mEntry.setImageResource(R.drawable.four)
                5 -> view.mEntry.setImageResource(R.drawable.five)
                6 -> view.mEntry.setImageResource(R.drawable.six)
                7 -> view.mEntry.setImageResource(R.drawable.seven)
                8 -> view.mEntry.setImageResource(R.drawable.eight)
                else -> view.mEntry.setImageResource(R.drawable.ic_baseline_person_24)
            }
        }
    }
}