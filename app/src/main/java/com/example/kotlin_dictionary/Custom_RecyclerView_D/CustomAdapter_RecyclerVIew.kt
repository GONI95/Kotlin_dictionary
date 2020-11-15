package com.example.kotlin_dictionary.Custom_RecyclerView_D

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.list_recycler_view_sample.view.*

class Data_r(val profile: Int, val name: String)

class CustomViewHolder(v : View) : RecyclerView.ViewHolder(v) {
    // 매개변수로 View를 받고 ViewHolder를 상속받음 (ViewHolder란 무수히 많은 데이터가 띄어질 때 한 화면에 표시되는 정보들을 보관하는 공간)
    // 매개변수의 v가 list로 보여질 레이아웃임
    val profile = v.listview_imageview
    val name = v.listview_textview
}

//class CustomAdapter_RecyclerVIew(val DataList_r : ArrayList<Data_r>, val context : Context)에서 context를 매개변수로 받지않으면,
// 아래의 context를 parent.context와 리스터에서 v -> 로 뷰를 콜백하여 v.context로 작성해야함
class CustomAdapter_RecyclerVIew(val DataList_r : ArrayList<Data_r>, val context : Context) : RecyclerView.Adapter<CustomViewHolder>(){
    // 하나의 list를 표현하는 레이아웃을 activity_custom_recycler_view.xml에 view로 만들어 넣어주어야해서 어댑터가 필요함, 상속받음

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val cellForRow = LayoutInflater.from(context).inflate(R.layout.list_recycler_view_sample, parent, false)
        // LayoutInflater이 레이아웃을 parent.context로 부터 팽창하는데, inflate로 list_recycler_view_sample를 view로 변환해 팽창함

        return CustomViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        // 수정하는 부분

        holder.profile.setImageResource(DataList_r[position].profile)
        //뒤의 prifile은 Data 클래스에서 매개변수로 받은 int형의 프로필 값의 데이터리스트의 위치
        holder.name.text = DataList_r[position].name

        holder.itemView.setOnClickListener{
            Toast.makeText(context, DataList_r[position].name, Toast.LENGTH_SHORT).show()
        }

    }

    override fun getItemCount(): Int = DataList_r.size
    // 뷰홀더의 갯수를 의미, 표시할 레이아웃 틀의 갯수를 설정하는 것, 리스트뷰는 암 이부분에서 렉이 걸릴 것
}