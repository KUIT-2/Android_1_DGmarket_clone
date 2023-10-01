package com.example.carrotmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class StuffInfoActivity : AppCompatActivity() {
    lateinit var binding: ActivityStuffInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 뒤로 가기 버튼
        binding.stuffABtnBack.setOnClickListener {
            finish()
        }

        // 프로필 온도 설정
        val heat = 36.6
        binding.stuffATvProfileHeat.text = getString(R.string.heat, heat)
    }
}