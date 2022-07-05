package com.example.test3

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_click_image.view.*
import kotlinx.android.synthetic.main.item_contacts.view.*

class ContactsViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    var view : View = v

    fun bind(item: Contacts) {
        view.mName.text = item.name
        view.mPhone.text = item.phone
        view.userImg.setImageResource(item.image)
    }
}