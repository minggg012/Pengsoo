package com.example.test3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_extra.*
import java.security.KeyStore

class ExtraFragment : Fragment() {

    private var EntryList = arrayListOf<ArrayList<ExtraEntry>>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initMap()

        return inflater.inflate(R.layout.fragment_extra, container, false)
    }

    override fun onStart() {
        super.onStart()

        val adapter = ExtraEntryAdapter(requireContext(), EntryList)
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
        EntryList.clear()

        for (i in 0 until 10) {
            val entryList: ArrayList<ExtraEntry> = arrayListOf()
            for (j in 0 until 10) {
                val entry = ExtraEntry()
                entryList.add(entry)
            }
            EntryList.add(entryList)
        }
    }
}