package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityAlarmBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class AlarmActivity : AppCompatActivity() {
    //View binding 적용
    lateinit var binding : ActivityAlarmBinding
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


    }
}
