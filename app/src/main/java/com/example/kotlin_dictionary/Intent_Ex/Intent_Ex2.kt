package com.example.kotlin_dictionary.Intent_Ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.activity_intent_ex2.*

class Intent_Ex2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_ex2)

        var message = intent.getStringExtra("mykey")

        val string = intent.getParcelableExtra<Student>("mydata")

        val studentList = intent.getParcelableArrayListExtra<Student>("mydata2")

        val bundle: Bundle? = intent.extras

        intent_textView.text =
            message + "\n\n"+
            string + "\n\n"+
            studentList.get(0).name + "\n\n"+
            bundle
    }
}