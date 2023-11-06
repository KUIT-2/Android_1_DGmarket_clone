package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.itemspace1.setOnClickListener {
            val intent_main_to_stuffinfo = Intent(this,StuffInfoActivity::class.java)
            startActivity(intent_main_to_stuffinfo)
        }
        binding.ivAlarm.setOnClickListener {
            val intent_main_to_alarms = Intent(this, Notification::class.java)
            startActivity(intent_main_to_alarms)
        }

        binding.navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_townlife -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, TownLifeFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_nearby -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, NearbyFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_chatting -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, ChattingFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_my -> {
                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, MyCarrotFragment()).commit()
                    return@setOnItemSelectedListener true
                }
                else -> {
                    return@setOnItemSelectedListener true
                }
            }
        }
        binding.navigation.selectedItemId = R.id.menu_home
        Log.d("당근마켓 클론코딩","main_onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("당근마켓 클론코딩","main_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("당근마켓 클론코딩","main_onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("당근마켓 클론코딩","main_onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("당근마켓 클론코딩","main_onStop")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("당근마켓 클론코딩","main_onDestroy")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("당근마켓 클론코딩","main_onRestart")
    }

}