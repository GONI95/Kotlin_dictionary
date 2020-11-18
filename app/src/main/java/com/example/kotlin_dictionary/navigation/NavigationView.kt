package com.example.kotlin_dictionary.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.kotlin_dictionary.AudioManager_VolumeUpDouwn.Volume_UpDown
import com.example.kotlin_dictionary.R
import com.example.kotlin_dictionary.Tablayout.Fragment_page1
import com.example.kotlin_dictionary.Tablayout.Fragment_page2
import com.example.kotlin_dictionary.Tablayout.Fragment_page3
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_navigationview.*
import kotlinx.android.synthetic.main.activity_progressbar.*
import kotlinx.android.synthetic.main.toolbar.*

// https://bongcando.tistory.com/4
// https://www.android4dev.com/navigation-drawer-using-navigation-view-in-android/

class NavigationView : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigationview)
        setSupportActionBar(main_layout_toolbar) // 툴바를 액티비티의 앱바로 지정
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // 드로어를 꺼낼 홈 버튼 활성화
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_android) // 홈버튼 이미지 변경


        main_navigationView.setNavigationItemSelectedListener(this@NavigationView) //navigation 리스너
        Vibrator(1000L)
    }

    private fun Vibrator(l: Long) {
        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        vibrator.vibrate(l)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> { // 메뉴 버튼
                main_drawer_layout.openDrawer(GravityCompat.START)    // 네비게이션 드로어 열기
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.page1 -> {
                navigateToFragment(Fragment_page1.newInstance())
                main_layout_toolbar.title = getString(R.string.page1)
                main_drawer_layout.closeDrawers()
            }
            R.id.page2 -> {
                navigateToFragment(Fragment_page2.newInstance())
                main_layout_toolbar.title = getString(R.string.page2)
                main_drawer_layout.closeDrawers()
            }
            R.id.page3 -> {
                navigateToFragment(Fragment_page3.newInstance())
                main_layout_toolbar.title = getString(R.string.page3)
                main_drawer_layout.closeDrawers()
            }
        }
        return false
    }

    private fun navigateToFragment(fragmentToNavigate: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragmentToNavigate)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() { //뒤로가기 처리
        if(main_drawer_layout.isDrawerOpen(GravityCompat.START)){
            main_drawer_layout.closeDrawers()
            // 테스트를 위해 뒤로가기 버튼시 Toast 메시지
            Toast.makeText(this, "back btn clicked", Toast.LENGTH_SHORT).show()
        } else{
            super.onBackPressed()
        }
    }

}