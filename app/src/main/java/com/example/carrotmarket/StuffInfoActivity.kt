package com.example.carrotmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.carrotmarket.databinding.ActivityMainBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class StuffInfoActivity : AppCompatActivity() {
    //view binding적용
    lateinit var binding : ActivityStuffInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backArrow.setOnClickListener {
            finish()
        }
        binding.goHome.setOnClickListener {
            val intent_stuffinfo_to_main = Intent(this,MainActivity::class.java)
            startActivity(intent_stuffinfo_to_main)
        }
        Log.d("당근마켓 클론코딩","stuffinfo_onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("당근마켓 클론코딩","stuffinfo_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("당근마켓 클론코딩","stuffinfo_onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("당근마켓 클론코딩","stuffinfo_onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("당근마켓 클론코딩","stuffinfo_onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("당근마켓 클론코딩","stuffinfo_onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("당근마켓 클론코딩","stuffinfo_onRestart")
    }
}