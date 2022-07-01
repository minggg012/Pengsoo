package com.example.test3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment() {
    private var imagesList: List<Images> = listOf(
        Images(R.drawable.a), Images(R.drawable.b), Images(R.drawable.c), Images(R.drawable.d), Images(R.drawable.e),
        Images(R.drawable.f), Images(R.drawable.g), Images(R.drawable.h), Images(R.drawable.i), Images(R.drawable.j),
        Images(R.drawable.k), Images(R.drawable.l), Images(R.drawable.m), Images(R.drawable.n), Images(R.drawable.o),
        Images(R.drawable.p), Images(R.drawable.q), Images(R.drawable.r), Images(R.drawable.s), Images(R.drawable.t),
        Images(R.drawable.u), Images(R.drawable.v)
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

//        adapter.setItemClickListener(object : GalleryAdapter.OnItemClickListener{
//            override fun onClick(v: View, position: Int) {
//                val selectedImage = imagesList[position]
//                startActivity(
//                    Intent(activity, ClickImageActivity.class).putExtra(
//                        "image",
//                        selectedImage
//                    )
//                )
//            }
//        })
        mGridView.adapter = adapter
    }

    fun newInstant(): GalleryFragment {
        val args = Bundle()
        val frag = GalleryFragment()
        frag.arguments = args
        return frag
    }

    inner class Images (val image: Int) {}

    inner class GalleryViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view : View = v

        val imagee: ImageView = view.findViewById(R.id.mImage)

//        fun bind(onClickListner: View.OnClickListener) {
//            view.setOnClickListener(onClickListner)
//        }





//        fun bind(item: Images) {
//            view.mimage.imageAlpha= item.image
//        }
    }


    inner class GalleryAdapter(private val imagesPhoto: List<Images>) :
        RecyclerView.Adapter<GalleryViewHolder>() {

        override fun getItemCount(): Int {
            return imagesPhoto.size
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
            val inflatedView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_gallery, parent, false)
            return GalleryViewHolder(inflatedView)
        }

        override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
            val item = imagesPhoto[position]
//            val adapter = this


            holder.imagee.setImageResource(item.image)
//            holder.apply {
//                bind(item)
//            }
//            holder.itemView.setOnClickListener {
//                itemClickListener.onClick(it, position)
//            }

        }
//        interface OnItemClickListener {
//            fun onClick(v: View, position: Int)
//        }
//        private lateinit var itemClickListener : OnItemClickListener
//
//        fun setItemClickListener(itemClickListener: OnItemClickListener) {
//            this.itemClickListener = itemClickListener
//        }


    }
}