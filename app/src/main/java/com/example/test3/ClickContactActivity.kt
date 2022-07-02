package com.example.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ClickContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_contact)

        var name = findViewById<TextView>(R.id.contact_name)
        var email = findViewById<TextView>(R.id.contact_email)
        var phone = findViewById<TextView>(R.id.contact_phone)
        var website = findViewById<TextView>(R.id.contact_website)

        name.text = intent.getStringExtra("name")
        email.text = intent.getStringExtra("email")
        phone.text = intent.getStringExtra("phone")
        website.text = intent.getStringExtra("website")
    }
}