package com.example.kotlin_dictionary.Sensor_Ex

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin_dictionary.R

class Sensor_EX : AppCompatActivity(), SensorEventListener {
    lateinit var sensorManager: SensorManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_ex)
    }

    // https://developer.android.com/guide/topics/sensors/sensors_motion?hl=ko
    override fun onSensorChanged(event: SensorEvent?) {
        // 센서의 값이 바뀌면 값을 출력
        val x = event?.values?.get(0) as Float
        val y = event?.values?.get(1) as Float
        val z = event?.values?.get(2) as Float

        println(x.toString() + ", " + y.toString() + ", " + z.toString())
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //accuracy -> 갯수(자이로스코프의 경우 x,y,z 3개)
        //sensor -> 센서의 종류
    }

    override fun onResume() {
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE), SensorManager.SENSOR_DELAY_NORMAL)
        // 센서 서비스를 가져와서 자이로스코프 센서를 보통의 속도로 읽음
        super.onResume()
    }

    override fun onPause() {
        sensorManager.unregisterListener(this)
        //어플이 가려지면 자원을 낭비를 막기위해 센서를 꺼지도록 함
        super.onPause()
    }

    
}