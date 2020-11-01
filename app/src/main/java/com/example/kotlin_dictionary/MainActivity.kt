package com.example.kotlin_dictionary

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("name 1: ", "onCreate()")

        var button = findViewById(R.id.button) as Button // as View

        button.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
    }
    fun btn(view: View) {
        //  1.  Toast.makeText(this, "Toast Message", Toast.LENGTH_SHORT).show()

        var toast = makeText(this, "Toast Message", Toast.LENGTH_SHORT) as Toast
        //  2.  toast.setGravity(Gravity.CENTER, 0, 0)
        //  3.  toast.setGravity(Gravity.END or Gravity.BOTTOM, 10, 10)
        toast.show()
    }

}