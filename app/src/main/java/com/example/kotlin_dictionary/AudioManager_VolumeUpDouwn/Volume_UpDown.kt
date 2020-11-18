package com.example.kotlin_dictionary.AudioManager_VolumeUpDouwn

import android.content.Context
import android.content.Intent
import android.media.AudioManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import com.example.kotlin_dictionary.R
import com.example.kotlin_dictionary.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_navigationview.*
import kotlinx.android.synthetic.main.activity_volumeupdown.*

class Volume_UpDown : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volumeupdown)
    }

    fun Audio(v:View){
        var audioManager = getSystemService(Context.AUDIO_SERVICE) as AudioManager
        audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        audioManager.getStreamVolume(AudioManager.STREAM_VOICE_CALL)
        audioManager.getStreamVolume(AudioManager.STREAM_RING)
        audioManager.getStreamVolume(AudioManager.STREAM_ALARM)
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 5, 0)
    }
}