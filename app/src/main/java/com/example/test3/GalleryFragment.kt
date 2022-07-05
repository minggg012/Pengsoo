package com.example.test3

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.fragment_gallery.*
import java.io.Serializable

class GalleryFragment : Fragment() {
    private var imagesList: ArrayList<Images> = arrayListOf(
        Images(R.drawable.a), Images(R.drawable.b), Images(R.drawable.c), Images(R.drawable.d), Images(R.drawable.e),
        Images(R.drawable.f), Images(R.drawable.g), Images(R.drawable.h), Images(R.drawable.i), Images(R.drawable.j),
        Images(R.drawable.k), Images(R.drawable.l), Images(R.drawable.m), Images(R.drawable.n), Images(R.drawable.o),
        Images(R.drawable.p), Images(R.drawable.q), Images(R.drawable.r), Images(R.drawable.s), Images(R.drawable.t),
        Images(R.drawable.u), Images(R.drawable.v)
    )

    private var informList: ArrayList<String> = arrayListOf(
        "망했어요", "공부좀해", "(이게 무슨 소리?)", "실성했습니까?", "(언제 끝나)", "눈치 챙겨", "(나는 프로다)", "이 빠보", "할 말 잃음", "대화 차단", "도망가자!", "왜여?", "오호 나이뜨!", "칭찬에 신남", "신이나", "아핳핳하", "난 할 수 있다!!", "시 시 시 작!", "오!!!", "WOW", "일단 이해한 척!!", "(안 들린다)"
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
        var adapter = GalleryAdapter(imagesList)

        adapter.setItemClickListener(object: GalleryAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                val selectedImage = imagesList[position]
                val informOfImage = informList[position]
                val intent = Intent(activity, ClickImageActivity::class.java)
                intent.putExtra("inform", informOfImage)
                startActivity(intent.putExtra("image", selectedImage))
            }
        })
        adapter.setItemLongClickListener(object: GalleryAdapter.OnItemLongClickListener{
            override fun onLongClick(v: View, position: Int): Boolean {
                println("-----------------------gallery longclick-------------------------")
                imagesList.remove(imagesList[position])
                informList.remove(informList[position])
                adapter.notifyDataSetChanged()
                Toast.makeText(context, "delete", Toast.LENGTH_SHORT).show()
                return true
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