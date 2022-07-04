package com.example.test3

import android.content.Context
import android.view.View
import android.widget.Toast

//enum class Status {
//    LAND, MINE, FLAG
//}

class ExtraEntry(var isCovered: Boolean = true, var isFlag: Boolean = false, var numOfMine: Int = 0) {

    public fun clickEntry (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {
        val item = entryList[position]
        if (!item.isCovered) return

        // else
        if (item.numOfMine == -1)
            explosion (context, adapter, entryList)
        else
            recursiveDiscover(context, adapter, entryList, position)
    }


    private fun explosion (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>) {
        Toast.makeText(context, "explosion!!!", Toast.LENGTH_SHORT).show()
    }

    private fun recursiveDiscover (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {

        val x: Int = position % 10
        val y: Int = position / 10
        if (x < 0 || x >= 10) return
        if (y < 0 || y >= 10) return

        // else
        entryList[position].isCovered = false
        adapter.notifyItemChanged(position)

        if (entryList[position].numOfMine > 0) return

        // else
        for (i in -1..1) {
            for (j in -1..1) {
                recursiveDiscover(context, adapter, entryList, x+i + 10*(y+j))
            }
        }
    }
}