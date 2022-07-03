package com.example.test3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ClickImageActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_image)
        imageView = findViewById(R.id.imageView)
        val intent = intent
        if (intent.extras != null) {
            val selectedImage = intent.getParcelableExtra<GalleryFragment.Images>("image")
            if (selectedImage != null) {
                imageView?.setImageResource(selectedImage.image)
            }
        }
    }
}