package com.example.kotlin_dictionary.Intent_Ex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_dictionary.MainActivity
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.activity_intent_ex.*

class Intent_Ex : AppCompatActivity() {
    var studentList = arrayListOf<Student>(
        Student("HEHE", 23),
        Student("MIMI", 24),
        Student("KAKA", 25)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_ex)

        var intent = Intent()
        var mystudent = Student("gee", 3)

        intent_button.setOnClickListener {
            intent.setAction(Intent.ACTION_SEND)

            intent.setType("text/plain")
            intent.putExtra(Intent.EXTRA_TITLE, title)
            intent.putExtra(Intent.EXTRA_TEXT, "공유 화면입니다.")
            intent.putExtra(Intent.EXTRA_SUBJECT, title)    // 안됨, 이유는 모르겠음 ㅠㅜ

            startActivity(Intent.createChooser(intent, "HI"))
        }

        intent_button1.setOnClickListener {
            intent = Intent(this, Intent_Ex2::class.java)

            intent.putExtra("mykey", "!!value!!")

            intent.putExtra("mydata", mystudent)

            intent.putParcelableArrayListExtra("mydata2", studentList)

            startActivity(intent)
            finish()
        }
    }
}