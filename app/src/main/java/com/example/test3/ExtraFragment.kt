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

class ExtraFragment : Fragment() {

    private var entryList = arrayListOf<ExtraEntry>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initMap()

        return inflater.inflate(R.layout.fragment_extra, container, false)
    }

    override fun onStart() {
        super.onStart()

        val adapter = ExtraEntryAdapter(entryList)
        adapter.setItemClickListener(object: ExtraEntryAdapter.OnItemClickListener {
            override fun onClick(v: View, position: Int) {
                Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
                v.mEntry.setImageResource(R.drawable.a)
            }
        })

        val myGridLayoutManager = object: GridLayoutManager(context, 10) {
            override fun canScrollVertically(): Boolean {
                return false
            }
        }
        grid_test.layoutManager = myGridLayoutManager
        grid_test.adapter = adapter
    }

    fun newInstant(): ExtraFragment
    {
        val args = Bundle()
        val frag = ExtraFragment()
        frag.arguments = args
        return frag
    }

    private fun initMap() {
        entryList.clear()
        for (i in 0 until 140) {
            val entry = ExtraEntry()
            entryList.add(entry)
        }
    }
}