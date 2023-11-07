package com.example.carrotmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityAlarmBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlarmActivity : AppCompatActivity() {
    //View binding 적용
    lateinit var binding: ActivityAlarmBinding
    private val tabList = arrayListOf("활동 알림", "키워드 알림")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        binding = ActivityAlarmBinding.inflate(layoutInflater)

        //기능 추가
        //뒤로 가기 아이콘 선택하면 HomeFragment 페이지로 넘어가도록 설정
        binding.tvAlarmPreviousArrow.setOnClickListener {
            finish()
        }
        setContentView(binding.root)

        initView()

    }

    private fun initView() {
        binding.mainVp.adapter = AlarmTabLayoutVPAdapter(this)


        //TabLayout의 viewpager 를 접목시키기 위해서 Mediator 와 attach사용한다.
        TabLayoutMediator(binding.mainTb, binding.mainVp) { tab, position ->  //코틀린 익명함수 람다
            tab.text = tabList[position]
        }.attach()

    }

}
