package com.example.carrotmarket

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.databinding.FragmentHomeBinding
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding


class StuffInfoActivity : AppCompatActivity() {
    //view binding 적용하고
    lateinit var binding: ActivityStuffInfoBinding

    private val imgList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stuff_info)
        binding = ActivityStuffInfoBinding.inflate(layoutInflater)

        initDummyData()
        initViewPager()
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

//            binding.ivDetailImgVp.setImageResource(data.thumbnail)
            binding.tvLocation.text = data.location
            binding.tvItemInfoTitle.text=data.title
            binding.ivBottomBarPrice.text = data.price
        }

    private fun initViewPager(){
        //생성자 안 context와 imgList 넣어주기
        binding.ivDetailImgVp.adapter = ImageSliderVPAdapter(applicationContext, imgList)
        binding.ivDetailImgVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL //가로 , 좌우로 swipe 방향 설정, 세로도 설정가능, default는 horizontal


    }

    private fun initDummyData(){

        imgList.add("https://cdn.pixabay.com/photo/2017/01/22/12/07/imac-1999636_1280.png")
        imgList.add("https://cdn.pixabay.com/photo/2015/01/08/18/25/desk-593327_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2014/09/24/14/29/macbook-459196_1280.jpg")

    }


    }
