package com.example.test3

import android.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter (fm : FragmentManager): FragmentPagerAdapter(fm) {
    //position 에 따라 원하는 Fragment로 이동시키기
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

    //tab의 개수만큼 return
    override fun getCount(): Int = 3

    //tab의 이름 fragment마다 바꾸게 하기
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