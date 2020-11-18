package com.example.kotlin_dictionary.mycalendarview

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_dictionary.R
import com.example.kotlin_dictionary.progressbar.ProgressBar
import com.example.kotlin_dictionary.web_videoview.Video
import kotlinx.android.synthetic.main.activity_mycalendarview.*
import kotlinx.android.synthetic.main.activity_web_view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.time.days

class Mycalendarview : AppCompatActivity() {
    var mnow = System.currentTimeMillis()
    var mDate = Date(mnow)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mycalendarview)

        //var mFormat = SimpleDateFormat("MM/dd/yyyy")

        //var time = mFormat.format(mDate)

        calendarView.maxDate = mDate.time
        calendarView.firstDayOfWeek = 2 //일요일 기준 1

        calendarView.setOnDateChangeListener{ calendarView, year, month, day ->
            //월이 인덱스로 0부터 시작함
        }
        val calendar = Calendar.getInstance()   // 현재날짜 가져옴
        calendar.set(2020,9,11)
        calendarView.setDate(calendar.timeInMillis) // set() 한 값을 뷰에 넣음
        println(calendar[Calendar.YEAR])
        println(calendar[Calendar.MONTH])
    }
}