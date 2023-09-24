package com.example.carrotmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.carrotmarket.databinding.ActivityAlarmBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding
import com.example.carrotmarket.databinding.FragmentHomeBinding

class AlarmActivity : AppCompatActivity() {
    lateinit var binding: ActivityAlarmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAlarmBinding.inflate(layoutInflater)

        //만들어놓은 화면 클릭시 상세정보(stuff로 이동)
        binding.ivBackAl.setOnClickListener{
            finish()
        }
        setContentView(binding.root)
    }
}