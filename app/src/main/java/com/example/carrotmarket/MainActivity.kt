package com.example.carrotmarket

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.carrotmarket.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_home -> {
                    //3주차에 실습한 코드, 저장하지 않으면 backstack에 저장되지 않음
                    supportFragmentManager.beginTransaction().replace(R.id.main_frm, HomeFragment()).commit()
                    return@setOnItemSelectedListener true //onclicklistner의 type때문에 사용하는 것
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
    }
}