package com.example.test3

import android.app.Activity
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_extra.view.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timerTask

class ExtraEntryList(private var entryList: ArrayList<ExtraEntry>, var numOfDiscovered: Int, var numOfFlag: Int, var onEvent: Boolean) {

    fun init () {
        entryList.clear()
        numOfDiscovered = 0
        numOfFlag = 0
    }
    fun clickEntry (rootView: View, position: Int, context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>) {
        val item = entryList[position]
        if (!item.isCovered) return

        // else
        onEvent = true
        println("------------------------onEvent = true------------------------")
        if (item.numOfMine == -1)
            explosion(context, adapter, entryList, position, 1)
        else
            recursiveDiscover(context, adapter, entryList, position)
        onEvent = false
        println("------------------------onEvent = false------------------------")
    }

    fun longClickEntry (rootView: View, position: Int, context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>) {
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
        rootView.remaining_mine.setText((10-numOfFlag).toString())
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
    private fun Succeed(context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {
        if (position == 100) {
            return
        }
        else {
            if (position == 1) {
                Toast.makeText(context, "Succeed!!!", Toast.LENGTH_SHORT).show()
                timerTask?.cancel()
            }
            entryList[position].isCovered = false
            entryList[position].numOfMine = 11

            adapter.notifyItemChanged(position)

            Handler(
                Looper.getMainLooper()).postDelayed({Succeed(context,adapter,entryList,position+1)}, 30)
        }
    }
    private fun Fail(context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {
        if (position == 100) {
            return
        }
        else {
            if (position == 1) {
                Toast.makeText(context, "Fail!!!", Toast.LENGTH_SHORT).show()
                timerTask?.cancel()
            }
            entryList[position].isCovered = false
            entryList[position].numOfMine = 10

            adapter.notifyItemChanged(position)

            Handler(
                Looper.getMainLooper()).postDelayed({Fail(context,adapter,entryList,position+1)}, 30)
        }
    }

    private fun recursiveDiscover (context: Context, adapter: ExtraEntryAdapter, entryList: ArrayList<ExtraEntry>, position: Int) {

        val x: Int = position % 10
        val y: Int = position / 10

        if (!entryList[position].isCovered) return

        // else
        entryList[position].isCovered = false
        numOfDiscovered += 1
        println("----------------- $numOfDiscovered------------------")
        adapter.notifyItemChanged(position)
        if (numOfDiscovered == 90) {
            Succeed(context, adapter, entryList,0)
        }

        if (entryList[position].numOfMine != 0) return

        // else
        for (i in -1..1) {
            for (j in -1..1) {
                if (x+i < 0 || x+i >= 10) continue
                if (y+j < 0 || y+j >= 10) continue
                Handler(
                    Looper.getMainLooper()).postDelayed({recursiveDiscover(context, adapter, entryList, x+i + 10*(y+j))}, 5)
            }
        }
    }
}