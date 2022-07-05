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
import kotlinx.android.synthetic.main.fragment_extra.view.*
import kotlinx.android.synthetic.main.item_extra.view.*
import java.security.KeyStore
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timer
var timerTask : Timer? = null
var time = 0

class ExtraFragment : Fragment() {

    private var entryList = ArrayList<ExtraEntry>()
    private lateinit var extraEntryList: ExtraEntryList
    private lateinit var rootView: View

    var failList = ArrayList<Int>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        extraEntryList = ExtraEntryList(entryList, 0, 0, false)
        initMap(null)

        rootView = inflater.inflate(R.layout.fragment_extra, container, false)
        return rootView

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
                extraEntryList.clickEntry(rootView, position, requireContext(), adapter, entryList)

            }
        })
        adapter.setItemLongClickListener(object: ExtraEntryAdapter.OnItemLongClickListener {
            override fun onLongClick(v: View, position: Int): Boolean {
                extraEntryList.longClickEntry(rootView, position, requireContext(), adapter, entryList)
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
            if (!extraEntryList.onEvent) {
                Toast.makeText(context, "RESET!!!", Toast.LENGTH_SHORT).show()
                timerTask?.cancel()
                time = 0
                remaining_mine.text = "10"
                passed_minute.text = "0"
                passed_second.text = "0"
                initMap(adapter)
            }
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

        time = 0
        timerTask = timer(period = 1000) {
            time++
            var min = time/60
            val sec = time % 60
            activity?.runOnUiThread {
//                passed_minute.text = "${min}"
//                passed_second.text = "${sec}"
                rootView.passed_minute.text = "${min}"
                rootView.passed_second.text = "${sec}"
            }
        }
        val range1 = (1..4)
        val fail1 = range1.random()
        val range2 = (1..2)
        val succeed1 = range2.random()
        for (i in 0 until 100) {
            val num = i+1
            val z = "00$num"
            val zz = z.substring(z.length-3 until z.length)

            var fail : Int? = null
            when (fail1) {
                1 -> fail = resources.getIdentifier("@drawable/z_"+zz, "drawable", requireActivity().packageName)
                2 -> fail = resources.getIdentifier("@drawable/b_"+zz, "drawable", requireActivity().packageName)
                3 -> fail = resources.getIdentifier("@drawable/e_"+zz, "drawable", requireActivity().packageName)
                4 -> fail = resources.getIdentifier("@drawable/h_"+zz, "drawable", requireActivity().packageName)
                else -> fail = resources.getIdentifier("@drawable/z_"+zz, "drawable", requireActivity().packageName)
            }


            var succeed : Int? = null
            when(succeed1) {
                1 -> succeed = resources.getIdentifier("@drawable/t_"+zz, "drawable", requireActivity().packageName)
                2-> succeed = resources.getIdentifier("@drawable/m_"+zz, "drawable", requireActivity().packageName)
                else -> succeed = resources.getIdentifier("@drawable/t_"+zz, "drawable", requireActivity().packageName)
            }

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