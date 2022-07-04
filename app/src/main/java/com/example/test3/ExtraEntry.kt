package com.example.test3

import android.content.Context
import android.view.View
import android.widget.Toast

class ExtraEntry(var isCovered: Boolean = true, var isFlag: Boolean = false, var numOfMine: Int = 0) {

    fun clickEntry (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {
        val item = entryList[position]
        if (!item.isCovered) return

        // else
        if (item.numOfMine == -1)
            explosion (context, adapter, entryList)
        else
            recursiveDiscover(context, adapter, entryList, position)
    }

    fun longClickEntry (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {
        val item = entryList[position]
        if (!item.isCovered) return

        // else
        item.isFlag = !item.isFlag
        adapter.notifyItemChanged(position)
    }


    private fun explosion (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>) {
        Toast.makeText(context, "explosion!!!", Toast.LENGTH_SHORT).show()
    }

    private fun recursiveDiscover (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {

        val x: Int = position % 10
        val y: Int = position / 10

        if (!entryList[position].isCovered) return

        // else
        entryList[position].isCovered = false
        adapter.notifyItemChanged(position)

        if (entryList[position].numOfMine != 0) return

        // else
        for (i in -1..1) {
            for (j in -1..1) {
                if (x+i < 0 || x+i >= 10) continue
                if (y+j < 0 || y+j >= 10) continue
                recursiveDiscover(context, adapter, entryList, x+i + 10*(y+j))
            }
        }
    }
}

