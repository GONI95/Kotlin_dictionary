package com.example.kotlin_dictionary.web_videoview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.activity_tablayout.*
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {
    var lastTimeBackPressed = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webview.webViewClient = WebViewClient()
        //새로운 버튼 눌렀을 때 새로운 창을 방지는 기능

        Load(netflixbutton)
    }
    override fun onBackPressed() {
        if(webview.canGoBack()) webview.goBack()
        else {
            if(System.currentTimeMillis() - lastTimeBackPressed < 1500){
                finish()
                return
            }
            lastTimeBackPressed = System.currentTimeMillis()
            //뒤로가기를 누르면 현재시간이 ltbp에 저장되는데 else의 경우에 버튼을 다시 누른 시간에 따라 종료됨
        }
    }

    fun Load(view: View) {
        when(view.id){
           R.id.netflixbutton -> webview.loadUrl("https://www.google.com/")
            R.id.naverbutton -> webview.loadUrl("https://naver.com/")
            //매니페스트 파일에서 인터넷 퍼미션 작업해주어야함
        }
    }
}