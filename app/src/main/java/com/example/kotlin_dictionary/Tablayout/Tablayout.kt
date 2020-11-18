package com.example.kotlin_dictionary.Tablayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.example.kotlin_dictionary.R
import com.example.kotlin_dictionary.web_videoview.WebView
import kotlinx.android.synthetic.main.activity_bottomnavigation.*
import kotlinx.android.synthetic.main.activity_tablayout.*
import kotlinx.android.synthetic.main.activity_widjetset.*

class Tablayout : AppCompatActivity() {

    var viewList = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tablayout)


        viewList.add(layoutInflater.inflate(R.layout.fragment_page1, null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_page2, null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_page3, null))

        viewPager_tl.adapter = pagerAdapter()

        tabLayout.setupWithViewPager(viewPager_tl)
        //탭 레이아웃을 가져와 뷰 페이저와 연결해주는 부분임
        tabLayout.getTabAt(0)?.setText("PAGE1")
        tabLayout.getTabAt(1)?.setText("PAGE2")
        tabLayout.getTabAt(2)?.setText("PAGE3")
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_android)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_android)
        tabLayout.getTabAt(2)?.setIcon(R.drawable.ic_android)

    }
    inner class pagerAdapter : PagerAdapter() {
        override fun getCount(): Int = viewList.size

        override fun isViewFromObject(view: View, `object`: Any) = view == `object`

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var currentView = viewList[position]
            viewPager_tl.addView(currentView)
            return currentView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            viewPager_tl.removeView(`object` as View)
        }
    }
}