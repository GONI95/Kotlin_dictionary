package com.example.kotlin_dictionary.web_videoview

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import com.example.kotlin_dictionary.R
import com.example.kotlin_dictionary.mycalendarview.Mycalendarview
import kotlinx.android.synthetic.main.activity_mycalendarview.*
import kotlinx.android.synthetic.main.activity_video.*

class Video : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        //val videoPath = "android.resource://" + getPackageName() + "/" + R.raw.(파일명)
        //videoview.setVideoPath(videoPath)
        // 위 방법은 raw 폴더에 mp4 파일을 넣어 실행하는 방법

        videoview.setVideoURI(Uri.parse("http://sites.google.com/site/ubiaccessmobile/sample_video.mp4"))

        val mediaController = MediaController(this)
        videoview.setMediaController(mediaController)
        videoview.keepScreenOn = true

        //videoview.start()/.pause/seekTo(10000)  : 시작, 정지, 10초 이동 명령
    }
    //https://tony-programming.tistory.com/entry/Android-VideoView-%EC%98%88%EC%A0%9C
}