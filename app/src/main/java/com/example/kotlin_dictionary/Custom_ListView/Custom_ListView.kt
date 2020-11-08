package com.example.kotlin_dictionary.Custom_ListView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.activity_custom__list_view.*

class Custom_ListView : AppCompatActivity() {

    //custeomAdapter에 전달할 DataList를 Data의 형식에 맞게 생성
   var DataList = arrayListOf(
        Data(R.mipmap.ic_launcher,"0번"),
        Data(R.mipmap.ic_launcher,"1번"),
        Data(R.mipmap.ic_launcher,"2번"),
        Data(R.mipmap.ic_launcher,"3번"),
        Data(R.mipmap.ic_launcher,"4번"),
        Data(R.mipmap.ic_launcher,"5번"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom__list_view)

        listView.adapter = CustomAdapter(this, DataList)
        // 원래는 리스트뷰의 어댑터에 ArrayAdapter를 이용하였지만, 직접 만든 CustomAdapter를 연결해주는 작업을 통해 모든 작업을 완료함
        // 하지만 ListView에는 data가 무수히 많아지면 그만큼 list들을 생성해주어야 하기때문에 렉이 심해짐, 그것을 보완한게 RecyclerView
        // RecyclerView는 표시되는 레이아웃 중 드래그 시 화면에 보이지않게되는 최상단의 레이아웃을 최하단 레이아웃으로 데이터만 바꾸어 재활용하여 데이터관리가 용이해짐

        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectItem = parent.getItemAtPosition(position) as Data
            Toast.makeText(this, selectItem.name, Toast.LENGTH_SHORT).show()
        }

    }
}