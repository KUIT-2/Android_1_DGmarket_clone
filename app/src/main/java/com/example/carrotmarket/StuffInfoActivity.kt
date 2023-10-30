package com.example.carrotmarket

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding

class StuffInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStuffInfoBinding
    private val imgList = mutableListOf<String>()

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
//        binding.stuffAImgArticle.setImageResource(data.thumnail) //상품 이미지
        binding.stuffATvAddress.text = data.address // 주소
        binding.stuffATvProductTitle.text = data.title //상품 제목

        initDummyData()
        initViewPager()
    }

    private fun initViewPager() {
        binding.stuffAImgArticle.adapter =
            StuffInfoImageSliderVPAdapter(applicationContext, imgList)
        binding.stuffAImgArticle.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 좌우로 스와이프
    }

    private fun initDummyData() {
        imgList.add("https://cdn.pixabay.com/photo/2017/01/11/15/35/busy-1972122_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2017/01/11/15/56/busy-1972169_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2017/01/11/15/26/busy-1972065_1280.jpg")
    }
}