package com.example.kotlin_dictionary.network_check

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import com.example.kotlin_dictionary.R
import kotlinx.android.synthetic.main.activity_network_check.*

// https://developer.android.com/training/basics/network-ops/managing?hl=ko
class Network_Check : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network_check)

        nc_button.setOnClickListener { NetworkCheck(nc_button) }

    }
    fun NetworkCheck(v: View) {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        //val wifiManager = getApplicationContext().getSystemService(Context.WIFI_SERVICE) as WifiManager
        //var wifistate = wifiManager.wifiState    //켜지면 3, 꺼지면 1이고 퍼미션에 ACCESS_WIFI_STATE 걸어줘야함

        var mobile_data_state = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isConnected
        var wifi_state = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected

        if(connectivityManager.activeNetworkInfo?.isConnected == null){
            println("와이파이, 모바일 데이터가 꺼져있습니다.")
            intent = Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
            startActivity(intent)
        } else if(wifi_state == false and mobile_data_state == true){
            println("와이파이가 꺼져있습니다.")
            intent = Intent(android.provider.Settings.ACTION_WIFI_SETTINGS)
            startActivity(intent)
        } else if(mobile_data_state == false and wifi_state == true){
            println("모바일 데이터가 꺼져있습니다.")
            intent = Intent(android.provider.Settings.ACTION_DATA_USAGE_SETTINGS)
            startActivity(intent)
        }
        // 위의 코드를 이용하여 AlertDialog로 상황에 따라 원하는 network를 켜도록 이용할 수도 있다.
    }
}