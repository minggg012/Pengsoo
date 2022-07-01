package com.example.test3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_contact.*

class ContactFragment : Fragment() {

    private val contactsList : List<Contacts> = listOf(
        Contacts("john","010-0000-11111"),
        Contacts("mir","010-1111-2222"),
        Contacts("delp", "010-3333-4444"),
        Contacts("jacob", "010-3333-5555"),
        Contacts("sheu", "010-3333-6666"),
        Contacts("ma", "010-3333-7777"),
        Contacts("ham", "010-3333-8889")
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onStart() {
        super.onStart()

        val adapter = ContactsListAdapter(contactsList)
        mRecyclerView.adapter = adapter
    }

    fun newInstant(): ContactFragment
    {
        val args = Bundle()
        val frag = ContactFragment()
        frag.arguments = args
        return frag
    }
}