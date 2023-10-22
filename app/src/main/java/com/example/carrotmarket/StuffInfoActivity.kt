package com.example.carrotmarket

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.carrotmarket.databinding.FragmentHomeBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding


class StuffInfoActivity : AppCompatActivity() {
    //view binding 적용하고
    lateinit var binding: ActivityStuffInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stuff_info)
        binding = ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //기능 추가
        //뒤로 가기 아이콘 선택하면 HomeFragment 페이지로 넘어가도록 설정
        binding.tvInfoPreviousArrow.setOnClickListener {
            finish()
        }

        //챌린지 미션 추가
        val data =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                intent.getSerializableExtra("information", ProductInfo::class.java)
            } else {
                intent.getSerializableExtra("key") as ProductInfo
            } ?: ProductInfo(R.drawable.icon_best_s, "null", "null", "null", "0", "0")

            binding.ivDetailView.setImageResource(data.thumbnail)
            binding.tvLocation.text = data.location
            binding.tvItemInfoTitle.text=data.title
            binding.ivBottomBarPrice.text = data.price
        }


    }
