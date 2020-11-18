package com.example.kotlin_dictionary.bottomnavigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.kotlin_dictionary.Custom_RecyclerView_D.Custom_RecyclerView
import com.example.kotlin_dictionary.R
import com.example.kotlin_dictionary.widjet_set.Widjet_set
import kotlinx.android.synthetic.main.activity_bottomnavigation.*
import kotlinx.android.synthetic.main.activity_custom__list_view.*
import kotlinx.android.synthetic.main.activity_tablayout.*


class Bottomnavigation : AppCompatActivity() {

    var viewList = ArrayList<View>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottomnavigation)

        viewList.add(layoutInflater.inflate(R.layout.fragment_page1, null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_page2, null))
        viewList.add(layoutInflater.inflate(R.layout.fragment_page3, null))

        viewPager_bn.adapter = pagerAdapter()

        viewPager_bn.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                when(position) {
                    0 -> bottomNavigationView.selectedItemId = R.id.page1
                    1 -> bottomNavigationView.selectedItemId = R.id.page2
                    2 -> bottomNavigationView.selectedItemId = R.id.page3
                }
            }
        })

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.page1 -> viewPager_bn.setCurrentItem(0)
                R.id.page2 -> viewPager_bn.setCurrentItem(1)
                R.id.page3 -> viewPager_bn.setCurrentItem(2)
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
    inner class pagerAdapter : PagerAdapter() {
        override fun getCount(): Int = viewList.size

        override fun isViewFromObject(view: View, `object`: Any) = view == `object`

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            var currentView = viewList[position]
            viewPager_bn.addView(currentView)
            return currentView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            viewPager_bn.removeView(`object` as View)
        }
    }
}

