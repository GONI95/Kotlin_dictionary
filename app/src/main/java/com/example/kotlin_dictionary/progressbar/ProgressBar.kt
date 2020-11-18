package com.example.kotlin_dictionary.progressbar

import android.animation.ValueAnimator
import android.app.Activity
import android.content.Intent
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.example.kotlin_dictionary.R
import com.example.kotlin_dictionary.mycalendarview.Mycalendarview
import com.example.kotlin_dictionary.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_mycalendarview.*
import kotlinx.android.synthetic.main.activity_progressbar.*
import java.sql.Time
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule
import kotlin.concurrent.timer
import kotlin.concurrent.timerTask
import kotlin.coroutines.CoroutineContext

class ProgressBar : AppCompatActivity() {
    var timer : Timer? = null
    //lateinit var timer : Timer // 타이머 형식, 전역변수로 하여 stop버튼 클릭 시 멈출 수 있음
    var deltaTime = 0   // deltaTime이 0~100까지 늘어날 것임

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progressbar)

        start_btn.setOnClickListener{ TimerFun() }
        stop_btn.setOnClickListener { TimerStop() }
    }

    fun TimerFun(){
        timer = timer(period = 100, initialDelay = 1000) {
            // 0.1초 마다 반복하며, intialDelay로 1초 후 시작
            if(deltaTime > 100) {
                cancel()
            }
            progressBar_horizontal.setProgress(++deltaTime)
            // 0~100까지 반복하고 조건문이 만족하지 않으면 cancel()로 빠져나옴
            println(progressBar_horizontal.progress)

            runOnUiThread{
                // 아래 코드를 runOnUiThread() 안에서 하지않으면 오류가 남, 즉 해당 함수는 timer 등에 넣어질 때 ui들이 안전하게 작동하게 해줌
                start_btn.text = "진행 중"
            }
        }
    }

    fun TimerStop(){
        timer?.cancel()
        runOnUiThread{
            // 아래 코드를 runOnUiThread() 안에서 하지않으면 오류가 남, 즉 해당 함수는 timer 등에 넣어질 때 ui들이 안전하게 작동하게 해줌
            start_btn.text = "시작"
        }
    }
}