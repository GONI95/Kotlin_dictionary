package com.example.kotlin_dictionary.pushAlarm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.kotlin_dictionary.MainActivity
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.activity_pushalarm.*

class PushAlarm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pushalarm)

        pushalarm_button.setOnClickListener {
            PushAlarm_Notification("푸쉬알람", "알람이 클릭되었습니다.")
        }
    }

    // https://developer.android.com/training/notify-user/build-notification?hl=ko
    fun PushAlarm_Notification(Title:String, Body:String){
        val pending = PendingIntent.getActivity(this, 0, Intent(this, PushAlarm::class.java), PendingIntent.FLAG_CANCEL_CURRENT)
        // 데이터를 전달하는데 필요한 Intent
        val builder = NotificationCompat.Builder(this, "id")
        // 알람을 설정
        builder.setSmallIcon(R.drawable.ic_android)
            .setContentTitle(Title)
            .setContentText(Body)
            .setContentIntent(pending)
            .setAutoCancel(true)    // 클릭 시 사라지게함
            .setPriority(NotificationCompat.PRIORITY_HIGH)  // 중요도
            .setDefaults(Notification.DEFAULT_ALL or Notification.DEFAULT_VIBRATE)  // 소리와 진동이 함께 발생

        val NManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        // 알람의 서비스를 가져옴
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            // 핸드폰의 sdk 버전이 VERSION_CONDES.0 보다 높으면 채널을 생성해주어야함
            NManager.createNotificationChannel(NotificationChannel("id","name",NotificationManager.IMPORTANCE_HIGH))
            // HIGH는 중요, LOW는 안중요함
        }
        NManager.notify(0, builder.build())
    }
}