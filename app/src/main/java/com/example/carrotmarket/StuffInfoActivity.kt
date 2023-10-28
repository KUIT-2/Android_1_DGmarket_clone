package com.example.carrotmarket

import android.os.Build
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

        // HomeFragment에서 intent로 정보 받아오기
        val data = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("Key", DataProduct::class.java)
        } else {
            intent.getSerializableExtra("Key") as DataProduct
        } ?: DataProduct(R.drawable.ic_warning_filled_s, "temp", "temp", "temp", 0, 0)

        // intent에 담긴 정보 받아와서 화면에 반영
        binding.stuffAImgArticle.setImageResource(data.thumnail) //상품 이미지
        binding.stuffATvAddress.text = data.address // 주소
        binding.stuffATvProductTitle.text = data.title //상품 제목
    }
}