package com.example.kotlin_dictionary.Custom_RecyclerView_D

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_dictionary.Custom_ListView.Data
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.activity_custom__recycler_view.*

class Custom_RecyclerView : AppCompatActivity() {

    //custeomAdapter에 전달할 DataList를 Data의 형식에 맞게 생성
    var DataList_r = arrayListOf(
        Data_r(R.mipmap.ic_launcher,"0번"),
        Data_r(R.mipmap.ic_launcher,"1번"),
        Data_r(R.mipmap.ic_launcher,"2번"),
        Data_r(R.mipmap.ic_launcher,"3번"),
        Data_r(R.mipmap.ic_launcher,"4번"),
        Data_r(R.mipmap.ic_launcher,"5번"),
        Data_r(R.mipmap.ic_launcher,"6번"),
        Data_r(R.mipmap.ic_launcher,"7번"),
        Data_r(R.mipmap.ic_launcher,"8번"),
        Data_r(R.mipmap.ic_launcher,"9번"),
        Data_r(R.mipmap.ic_launcher,"10번")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom__recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(this)
        // 29버전에선 LinearLayoutManager를 지원하지않아 마이그레이션 했음, 위 작업을 통해 드레그가 가능하게됨(마치 스크롤 뷰에 리니어 레이아웃을 생성한 것과 같음)
        recyclerView.adapter = CustomAdapter_RecyclerVIew(DataList_r, this)
        //listView와 동일하게 커스텀 어댑터가 필요

    }
}