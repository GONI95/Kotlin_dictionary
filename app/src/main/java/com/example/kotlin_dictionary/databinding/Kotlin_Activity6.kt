package com.example.kotlin_dictionary.databinding

import android.app.IntentService
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.kotlin_dictionary.Custom_ListView.Custom_ListView
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.activity_kotlin_6.*

class Kotlin_Activity6 : AppCompatActivity(){
    private lateinit var binding : ActivityKotlin6Binding
    // 늦은 초기화와 데이터바인딩 선언 , xml 파일명이 CamelCase 표기로 변경

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_kotlin_6)
        var user = User("이상곤", "Lee", "sang", "gon")
        binding.userdata = user
    }
}