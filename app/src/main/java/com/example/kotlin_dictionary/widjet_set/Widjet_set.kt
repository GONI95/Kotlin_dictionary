package com.example.kotlin_dictionary.widjet_set

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlin_dictionary.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_widjetset.*

class Widjet_set : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widjetset)

        // ===================================================================
        switch_1.setOnCheckedChangeListener { buttonView, isChecked ->
            //buttonView = Compoundbutton : 상태가 변경된 복합 버튼보기 , isChecked = boolean : buttonView의 체크 상태
            println("스위치"+isChecked)
            println("스위치"+buttonView)
        }
        switch_1.isChecked = false
        // 초기 버튼 상태 설정을 false
        // ===================================================================


        // ===================================================================
        checkBox1.setOnCheckedChangeListener { buttonView, isChecked ->
            //buttonView = Compoundbutton : 상태가 변경된 복합 버튼보기 , isChecked = boolean : buttonView의 체크 상태
            println("체크박스"+isChecked)
        }
        checkBox1.isChecked = false
        // 초기 버튼 상태 설정을 false
        // ===================================================================


        // ===================================================================
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            //buttonView = Compoundbutton : 상태가 변경된 복합 버튼보기 , isChecked = boolean : buttonView의 체크 상태
            when(checkedId){
                R.id.radioButton1 -> println("라디오버튼1")
                R.id.radioButton2 -> println("라디오버튼2")
                R.id.radioButton3 -> println("라디오버튼3")
            }
        }
        radioGroup.check(R.id.radioButton1)
        //radioGroup.clearCheck() : 전부 다 논클릭

        when(radioGroup.checkedRadioButtonId){
            //조건을 체크된 id로 구별하니 어디서든 필요할 때 사용가능
            R.id.radioButton1 -> println("1")
            R.id.radioButton2 -> println("2")
            R.id.radioButton3 -> println("3")
        }
        // ===================================================================


        // ===================================================================
        toggleButton.isChecked = true
        toggleButton.setOnCheckedChangeListener { buttonView, isChecked ->
            println("토글"+isChecked)
        }
        // ===================================================================


        // ===================================================================
        fab.setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                // Type에 ?를 붙이면 null이 가능한 변수임을 명시적으로 표현
                // 연산자에 ?.를 붙이면 앞의 변수가 null 아닐때만 우측함수 실행 null이면 null 반환
                // !!는 변수가 강제로 null이 아님을 선언하는데 null을 넣게되면 NPE가 발생
                // 이 들의 경우 전 후 함수, 변수에 CASCADING하게 ?, ?., !!를 처리하면 오류 시 찾기가 힘듭니다.
                if (view != null) {
                    Snackbar.make(view, "나는 스낵바!", Snackbar.LENGTH_SHORT)
                    // 보기가 힘들어도 view!! 대신 if문으로 처리하였음
                        .setAction("새로운 명령", { println("함수 실행 가능")})
                        // 스낵바 내에서 새로운 명령을 실행가능함
                        .show()
                }
            }
        })
        /*
        fab.setOnClickListener { view -> // v -> : 뷰 형식을 매개변수로 받음
            Snackbar.make(view, "나는 스낵바!", Snackbar.LENGTH_SHORT).show()
        }*/
        // ===================================================================

    }
}