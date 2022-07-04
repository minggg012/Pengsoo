package com.example.test3

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_gallery.*
import java.io.Serializable

class GalleryFragment : Fragment() {
    private var imagesList: List<Images> = listOf(
        Images(R.drawable.a), Images(R.drawable.b), Images(R.drawable.c), Images(R.drawable.d), Images(R.drawable.e),
        Images(R.drawable.f), Images(R.drawable.g), Images(R.drawable.h), Images(R.drawable.i), Images(R.drawable.j),
        Images(R.drawable.k), Images(R.drawable.l), Images(R.drawable.m), Images(R.drawable.n), Images(R.drawable.o),
        Images(R.drawable.p), Images(R.drawable.q), Images(R.drawable.r), Images(R.drawable.s), Images(R.drawable.t),
        Images(R.drawable.u), Images(R.drawable.v)
    )

    private var informList = arrayOf(
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onStart() {
        super.onStart()

        val manager = GridLayoutManager(activity, 3, GridLayoutManager.VERTICAL, false)
        mGridView.layoutManager = manager
        val adapter = GalleryAdapter(imagesList)

        adapter.setItemClickListener(object: GalleryAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                val selectedImage = imagesList[position]
                val informOfImage = informList[position]
                val intent = Intent(activity, ClickImageActivity::class.java)
                intent.putExtra("inform", informOfImage)
                startActivity(intent.putExtra("image", selectedImage))
            }
        })
        mGridView.adapter = adapter
    }

    fun newInstant(): GalleryFragment {
        val args = Bundle()
        val frag = GalleryFragment()
        frag.arguments = args
        return frag
    }
    @Parcelize
    data class Images (val image: Int) : Parcelable





}