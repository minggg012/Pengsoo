package com.example.test3

import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_click_image.*

class ClickImageActivity : AppCompatActivity() {
    private var informOfImage: String? = null
    private var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_image)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
        imageView = findViewById(R.id.imageView)
        val intent = intent
        informOfImage = intent.getStringExtra("inform")
        if (intent.extras != null) {
            val selectedImage = intent.getParcelableExtra<GalleryFragment.Images>("image")

            if (selectedImage != null) {
                imageView?.setImageResource(selectedImage.image)

            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
//            R.id.delete -> {
//                Toast.makeText(this, "Do you want to delete 펭수...?", Toast.LENGTH_SHORT).show()
//                Toast.makeText(this, "Sorry, you cannot.", Toast.LENGTH_SHORT).show()
//            }
            R.id.inform -> AlertDialog.Builder(this).run {
                setTitle("information")
                setMessage(informOfImage)
                setNegativeButton("OK", null)
                show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}