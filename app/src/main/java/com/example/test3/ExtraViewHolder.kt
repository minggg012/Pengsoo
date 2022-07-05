package com.example.test3

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_extra.view.*
import java.security.AccessController.getContext

class ExtraViewHolder(v: View): RecyclerView.ViewHolder(v) {
    var view: View = v

    fun bind(item: ExtraEntry) {

        if (!item.isCovered) { // covered
            val index = item.numOfMine
            when(index) {
                -2 -> {
                    view.mEntry.setImageResource(R.drawable.bomb)
                }
                0 -> view.mEntry.setImageResource(R.drawable.zero)
                1 -> view.mEntry.setImageResource(R.drawable.one)
                2 -> view.mEntry.setImageResource(R.drawable.two)
                3 -> view.mEntry.setImageResource(R.drawable.three)
                4 -> view.mEntry.setImageResource(R.drawable.four)
                5 -> view.mEntry.setImageResource(R.drawable.five)
                6 -> view.mEntry.setImageResource(R.drawable.six)
                7 -> view.mEntry.setImageResource(R.drawable.seven)
                8 -> view.mEntry.setImageResource(R.drawable.eight)
                10 -> {
                    val i = item.failImage
                    view.mEntry.setImageResource(i)
                }
                11 -> {
                    val i = item.succeedImage
                    view.mEntry.setImageResource(i)
                }
                else -> view.mEntry.setImageResource(R.drawable.ic_baseline_person_24)
            }
        }
        else if (item.isFlag) {
            view.mEntry.setImageResource(R.drawable.flag)
        }
        else { // covered, no flag
            view.mEntry.setImageResource(R.drawable.white)
        }
    }
}