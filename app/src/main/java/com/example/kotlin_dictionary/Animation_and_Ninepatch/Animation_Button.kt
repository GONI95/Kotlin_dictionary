package com.example.kotlin_dictionary.Animation_and_Ninepatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.activity_animation_button.*
import render.animations.Bounce
import render.animations.Render

class Animation_Button : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation_button)

        am_button.setOnClickListener {
            // Create Render Class
            val render = Render(this)

            // Set Animation
            render.setAnimation(Bounce().InDown(am_button))
            render.start()
        }
    }
}