package com.example.carrotmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.carrotmarket.databinding.ActivityAlarmBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding
import com.example.carrotmarket.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class AlarmActivity : AppCompatActivity() {
    lateinit var binding: ActivityAlarmBinding
    //alarm에서 fragment화면 바뀌니 여기서 tablayout 구현해야될듯
    private val tabList= arrayListOf("활동 알림","키워드 알림")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityAlarmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        binding.ivBackAl.setOnClickListener{
            finish()
        }
    }

    private fun initView() {
            binding.mainVp.adapter=AlarmTabLayoutVPAdapter(this)//액티비티 받는다 했으니 그냥 이거 넣어주면 된다
            TabLayoutMediator(binding.mainTb,binding.mainVp){tab,position->
                tab.text=tabList[position]//어떤 데이타 넣을지
                //익명함수를 통해 구현 가능
                // 연결함 탭래이아웃을 어떤식으로 구성할지를 넣어줘야함 람다함수 공부하기
            }.attach()//꼭 써야
    }
}