package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityAlarmBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlarmActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAlarmBinding
    private val tabList = arrayListOf("활동 알림", "키워드 알림")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAlarmBinding.inflate(layoutInflater)

        // 뒤로 가기 버튼
        binding.alarmABtnBack.setOnClickListener {
            finish()
        }

        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.alarmAViewPager2.adapter = AlarmATabLayoutVPAdapter(this)

        // ViewPager와 TabLayout을 연동해주기
        TabLayoutMediator(binding.alarmATab, binding.alarmAViewPager2) { tab, position ->
            tab.text = tabList[position]
        }.attach()
    }
}