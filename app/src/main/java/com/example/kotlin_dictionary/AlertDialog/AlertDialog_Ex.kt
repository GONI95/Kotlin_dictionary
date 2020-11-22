package com.example.kotlin_dictionary.AlertDialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.activity_alert_dialog_ex.*
import kotlinx.android.synthetic.main.custom_dialog.*

class AlertDialog_Ex : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog_ex)

        alertDialog_button.setOnClickListener {
            var ad = AlertDialog.Builder(this)
            var view1 = layoutInflater.inflate(R.layout.custom_dialog, null)
            ad.setIcon(R.drawable.ic_android)
            ad.setTitle("다이어로그 제목")
            ad.setMessage("다이어로그를 누르셨습니다. 원하는 작업을 하세요.")
            ad.setView(view1)
            ad.setPositiveButton("보내기", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    // dialog로 해당 다이어그로를 받아 객체를 생성하여 연결해주면 됨(이런 방식으로 날짜, 시간, 프로그레스 등 가능)
                    // https://sbe03005dev.tistory.com/entry/Android-Kotlin-%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EC%BD%94%ED%8B%80%EB%A6%B0-%EB%8B%A4%EC%9D%B4%EC%96%BC%EB%A1%9C%EA%B7%B8-Dialog
                    var alert = dialog as AlertDialog
                    var edit = alert.findViewById<EditText>(R.id.dialog_ed)
                    alertDialog_button.text = edit?.text.toString()

                    dialog?.dismiss()
                }
            })
            ad.setNegativeButton("끄기", object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {

                    dialog?.dismiss()
                }
            })
            ad.show()
        }
    }
}