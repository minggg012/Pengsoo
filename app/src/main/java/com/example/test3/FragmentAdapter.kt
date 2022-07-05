package com.example.test3

import android.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter (fm : FragmentManager): FragmentPagerAdapter(fm) {

    // move to desired Fragment according to the POSITION
    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        val fragment =  when(position)
        {
            0-> ContactFragment().newInstant()
            1-> GalleryFragment().newInstant()
            2-> ExtraFragment().newInstant()
            else-> ContactFragment().newInstant()
        }
        return fragment
    }

    // return the number of tabs
    override fun getCount(): Int = 3

    // set the name of tabs
    override fun getPageTitle(position: Int): CharSequence? {
        val title = when(position)
        {
            0->"CONTACTS"
            1->"GALLERY"
            2->"MINESWEEPER"
            else -> "MAIN"
        }
        return title     }
}