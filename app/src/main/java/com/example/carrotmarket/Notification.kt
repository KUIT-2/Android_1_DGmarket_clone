package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.carrotmarket.databinding.ActivityNotificationBinding

class Notification : AppCompatActivity() {
    lateinit var binding : ActivityNotificationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.notificationGobackArrow.setOnClickListener {
            finish()
        }
    Log.d("당근마켓 클론코딩","notification_onCreate")
    }
    override fun onStart() {
        super.onStart()
        Log.d("당근마켓 클론코딩","notification_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("당근마켓 클론코딩","notification_onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("당근마켓 클론코딩","notification_onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("당근마켓 클론코딩","notification_onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("당근마켓 클론코딩","notification_onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("당근마켓 클론코딩","notification_onRestart")
    }
}