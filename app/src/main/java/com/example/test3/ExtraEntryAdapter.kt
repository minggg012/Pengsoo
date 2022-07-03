package com.example.test3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.item_extra.view.*

class ExtraEntryAdapter(val context: Context, private val itemList: List<List<ExtraEntry>>): BaseAdapter() {

    override fun getCount(): Int {
        return itemList.size * itemList[0].size
    }

    override fun getItem(p0: Int): Any {
        return itemList[p0 / itemList[0].size][p0 % itemList[0].size]
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_extra, null)
        view.mEntry.setImageResource(R.drawable.ic_baseline_person_24)

        return view
    }
}