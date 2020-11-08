package com.example.kotlin_dictionary.Custom_ListView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlin_dictionary.R

class Data(val profile: Int, val name: String)

class CustomAdapter (val context: Context, val DataList: ArrayList<Data>) : BaseAdapter() {
    override fun getCount(): Int {
        //getCount() = DataList.size로도 가능
        return DataList.size
    }

    override fun getItem(position: Int) = DataList[position]

    override fun getItemId(position: Int) = 0L

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = LayoutInflater.from(context).inflate(R.layout.list_recycler_view_sample, null)

        val profile = view.findViewById<ImageView>(R.id.listview_imageview)
        val name = view.findViewById<TextView>(R.id.listview_textview)
        val data = DataList[position]

        profile.setImageResource(data.profile)
        name.text = data.name
        return view

        // 매개변수로 받은 context로 부터 레이아웃을 새로만듬(listview_sample을 activity_custom_list_view에
        // 대입시키기위해 변환과정이 필요함, 그것을 LayoutInflater로 가능하고, 매개변수로 Data에 전달한 정보를
        // data.profile과 data.name을 통해 대입하는 작업을 완료하면 해당 view를 반환)
        //
    }

}