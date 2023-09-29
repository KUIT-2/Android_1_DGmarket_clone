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

        binding.navigation.setOnItemSelectedListener {//아이템이 클릭되면 무엇을 할 것인가
            when(it.itemId){//선택된 아이템의 Id, menu에 따라 다른 fragment 사용, backstack 사용 안 하고있음
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
                else -> {// Itemlistner 타입 떄매 사용
                    return@setOnItemSelectedListener true
                }
            }
        }
        binding.navigation.selectedItemId = R.id.menu_home
    }
}