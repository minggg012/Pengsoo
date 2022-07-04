package com.example.test3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_extra.*
import kotlinx.android.synthetic.main.item_extra.view.*
import java.security.KeyStore
import kotlin.concurrent.timer

class ExtraFragment : Fragment() {

    private var entryList = ArrayList<ExtraEntry>()
    private var extraEntryList = ExtraEntryList(entryList, 0, 0)
    var failList = ArrayList<Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        extraEntryList = ExtraEntryList(entryList, 0, 0)
        initMap(null)

        return inflater.inflate(R.layout.fragment_extra, container, false)

    }

    override fun onStart() {
        super.onStart()
        //initMap()
        for (i in 0 until 100) {
            val n = entryList[i].numOfMine
            println("$i " + "$n\n")
        }
        val adapter = ExtraEntryAdapter(entryList)
        adapter.setItemClickListener(object: ExtraEntryAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                extraEntryList.clickEntry(v, position, requireContext(), adapter, entryList)
            }
        })
        adapter.setItemLongClickListener(object: ExtraEntryAdapter.OnItemLongClickListener {
            override fun onLongClick(v: View, position: Int): Boolean {
                extraEntryList.longClickEntry(v, position, requireContext(), adapter, entryList)
                return true
            }
        })

        val myGridLayoutManager = object: GridLayoutManager(context, 10) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        grid_test.layoutManager = myGridLayoutManager
        grid_test.adapter = adapter

        reset.setOnClickListener {
            Toast.makeText(context, "RESET!!!", Toast.LENGTH_SHORT).show()
            initMap(adapter)
        }

    }

    fun newInstant(): ExtraFragment
    {
        val args = Bundle()
        val frag = ExtraFragment()
        frag.arguments = args
        return frag
    }

    private fun initMap(adapter: ExtraEntryAdapter?) {
        extraEntryList.init()

        timer(period = 100) {

        }
        for (i in 0 until 100) {
            val num = i+1
            val z = "00$num"
            val zz = z.substring(z.length-3 until z.length)
            val fail = resources.getIdentifier("@drawable/z_"+zz, "drawable", requireActivity().packageName)
            val succeed = resources.getIdentifier("@drawable/t_"+zz, "drawable", requireActivity().packageName)
            val entry = ExtraEntry(true, false, 0, fail, succeed)
            entryList.add(entry)
            if (adapter != null)
                adapter.notifyItemChanged(i)
        }

        val range = (0..99)
        for (i in 0 until 10) {
            var index = range.random()
            while (entryList[index].numOfMine == -1) {
                index = range.random()
            }
            entryList[index].numOfMine = -1
        }
        for (i in 0 until 100) {
            val x = i / 10
            val y = i % 10
            if (entryList[i].numOfMine == -1) {

            }
            else {
                entryList[i].numOfMine = checkAround(x, y, entryList)
            }
        }


    }
    fun checkAround(x: Int, y: Int, list: ArrayList<ExtraEntry>) : Int {
        var count = 0
        for (i in x-1 until x+2) {
            for (j in y-1 until y+2) {
                if (i in 0..9 && j in 0..9) {
                    val index = i*10 + j
                    if (list[index].numOfMine == -1) {
                        count++
                    }
                }
            }
        }

        return count
    }
}