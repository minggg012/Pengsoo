package com.example.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ClickImageActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_image)
        imageView = findViewById(R.id.mImage)
        val intent = intent
        if (intent.extras != null) {
            val selectedImage = intent.getIntExtra("image", 0)
            imageView?.setImageResource(selectedImage)
        }
    }
}