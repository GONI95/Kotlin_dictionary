package com.example.kotlin_dictionary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_dictionary.AlertDialog.AlertDialog_Ex
import com.example.kotlin_dictionary.Animation_and_Ninepatch.Animation_Button
import com.example.kotlin_dictionary.AudioManager_VolumeUpDouwn.Volume_UpDown
import com.example.kotlin_dictionary.Custom_ListView.Custom_ListView
import com.example.kotlin_dictionary.Custom_RecyclerView_D.Custom_RecyclerView
import com.example.kotlin_dictionary.Intent_Ex.Intent_Ex
import com.example.kotlin_dictionary.Sensor_Ex.Sensor_EX
import com.example.kotlin_dictionary.SharedPreference.SharedPreference
import com.example.kotlin_dictionary.Tablayout.Tablayout
import com.example.kotlin_dictionary.bottomnavigation.Bottomnavigation
import com.example.kotlin_dictionary.mycalendarview.Mycalendarview
import com.example.kotlin_dictionary.navigation.NavigationView
import com.example.kotlin_dictionary.network_check.Network_Check
import com.example.kotlin_dictionary.progressbar.ProgressBar
import com.example.kotlin_dictionary.pushAlarm.PushAlarm
import com.example.kotlin_dictionary.web_videoview.Video
import com.example.kotlin_dictionary.web_videoview.WebView
import com.example.kotlin_dictionary.widjet_set.Widjet_set
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.nextButton_2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nextbutton_1.setOnClickListener {
            val intent = Intent(this, Custom_ListView::class.java)
            startActivity(intent)
        }

        nextButton_2.setOnClickListener {
            val intent = Intent(this, Custom_RecyclerView::class.java)
            startActivity(intent)
        }

        nextButton_3.setOnClickListener {
            val intent = Intent(this, Bottomnavigation::class.java)
            startActivity(intent)
        }

        nextButton_4.setOnClickListener {
            val intent = Intent(this, Widjet_set::class.java)
            startActivity(intent)
        }

        nextButton_5.setOnClickListener {
            val intent = Intent(this, Tablayout::class.java)
            startActivity(intent)
        }

        nextButton_6.setOnClickListener {
            val intent = Intent(this, WebView::class.java)
            startActivity(intent)
        }

        nextButton_7.setOnClickListener {
            val intent = Intent(this, Video::class.java)
            startActivity(intent)
        }

        nextButton_8.setOnClickListener {
            val intent = Intent(this, Mycalendarview::class.java)
            startActivity(intent)
        }

        nextButton_9.setOnClickListener {
            val intent = Intent(this, ProgressBar::class.java)
            startActivity(intent)
        }

        nextButton_10.setOnClickListener {
            val intent = Intent(this, NavigationView::class.java)
            startActivity(intent)
        }

        nextButton_11.setOnClickListener {
            val intent = Intent(this, Volume_UpDown::class.java)
            startActivity(intent)
        }

        nextButton_12.setOnClickListener {
            val intent = Intent(this, PushAlarm::class.java)
            startActivity(intent)
        }

        nextButton_13.setOnClickListener {
            val intent = Intent(this, SharedPreference::class.java)
            startActivity(intent)
        }

        nextButton_14.setOnClickListener {
            val intent = Intent(this, Sensor_EX::class.java)
            startActivity(intent)
        }

        nextButton_15.setOnClickListener {
            val intent = Intent(this, Network_Check::class.java)
            startActivity(intent)
        }

        nextButton_16.setOnClickListener {
            val intent = Intent(this, AlertDialog_Ex::class.java)
            startActivity(intent)
        }

        nextButton_17.setOnClickListener {
            val intent = Intent(this,  Intent_Ex::class.java)
            startActivity(intent)
        }

        nextButton_18.setOnClickListener {
            val intent = Intent(this,  Animation_Button::class.java)
            startActivity(intent)
        }
    }
}