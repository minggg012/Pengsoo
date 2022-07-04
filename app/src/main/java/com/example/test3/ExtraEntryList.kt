package com.example.test3

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.widget.Toast

class ExtraEntryList(val entryList: List<ExtraEntry>, var numOfDiscovered: Int, var numOfFlag: Int) {

    fun clickEntry (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {
        val item = entryList[position]
        if (!item.isCovered) return

        // else
        if (item.numOfMine == -1)
            explosion (context, adapter, entryList, position, 1)
        else
            recursiveDiscover(context, adapter, entryList, position)
    }

    fun longClickEntry (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {
        val item = entryList[position]
        if (!item.isCovered) return

        // else
        if (item.isFlag) {
            item.isFlag = false
            numOfFlag -= 1
        }
        else {
            item.isFlag = true
            numOfFlag += 1
        }
        adapter.notifyItemChanged(position)
    }


    private fun explosion (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int, count: Int) {

        val range = (0..99)
        if (count > 10 || count < 1) {
            return
        }
        if (count == 10) {
            entryList[position].isCovered = false
            adapter.notifyItemChanged(position)
            entryList[position].numOfMine = -2
            Fail(context, adapter, entryList, 0)
            return
        }
        else {
            entryList[position].isCovered = false
            adapter.notifyItemChanged(position)
            entryList[position].numOfMine = -2
            //Toast.makeText(context, "explosion!!!", Toast.LENGTH_SHORT).show()
            var index = range.random()
            while (entryList[index].numOfMine != -1) {
                index = range.random()
            }
            Handler(
                Looper.getMainLooper()).postDelayed({explosion(context,adapter,entryList,index,count+1)}, 200)
        }




    }
    private fun Fail(context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {
        if (position == 100) {
            return
        }
        else {
            entryList[position].isCovered = false
            entryList[position].numOfMine = 10

            adapter.notifyItemChanged(position)

            Handler(
                Looper.getMainLooper()).postDelayed({Fail(context,adapter,entryList,position+1)}, 50)
        }
    }

    private fun recursiveDiscover (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {

        val x: Int = position % 10
        val y: Int = position / 10

        if (!entryList[position].isCovered) return

        // else
        entryList[position].isCovered = false
        numOfDiscovered += 1
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