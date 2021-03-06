package com.example.test3

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_contact.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream

class ContactFragment : Fragment() {

    private var contactsList = arrayListOf<Contacts>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onStart() {
        super.onStart()

        jsonParsing(getJsonString())
        val adapter = ContactsListAdapter(contactsList)
        adapter.setItemClickListener(object: ContactsListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                val nextIntent = Intent(activity, ClickContactActivity::class.java)
                nextIntent.putExtra("name", contactsList[position].name)
                nextIntent.putExtra("email", contactsList[position].email)
                nextIntent.putExtra("phone", contactsList[position].phone)
                nextIntent.putExtra("website", contactsList[position].website)
                nextIntent.putExtra("image", contactsList[position].image)
                startActivity(nextIntent)
            }
        })
        adapter.setItemLongClickListener(object: ContactsListAdapter.OnItemLongClickListener {
            override fun onLongClick(v: View, position: Int): Boolean {
                val item = contactsList[position]
                Toast.makeText(context, item.json, Toast.LENGTH_LONG).show()
                return true
            }
        })
        mRecyclerView.adapter = adapter
    }

    fun newInstant(): ContactFragment
    {
        val args = Bundle()
        val frag = ContactFragment()
        frag.arguments = args
        return frag
    }

    private fun getJsonString(): String {
        var json = ""
        try {
            val inputStream: InputStream = requireContext().assets.open("contacts.json")
            val fileSize: Int = inputStream.available()
            val buffer = ByteArray(fileSize)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return json
    }

    private fun jsonParsing(json: String) {
        contactsList.clear()
        try {
            val jsonObject = JSONObject(json)
            val contactArray = jsonObject.getJSONArray("contacts")
            println(contactArray)
            for (i in 0..contactArray.length()) {
                val contactObject: JSONObject = contactArray.getJSONObject(i)

                val contact = Contacts(contactObject.getString("name"), contactObject.getString("email")
                    ,contactObject.getString("phone"), contactObject.getString("website")
                    ,resources.getIdentifier(contactObject.getString("profile"), "drawable", requireActivity().packageName)
                    ,contactObject.toString())
                contactsList.add(contact)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }
}