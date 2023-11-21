package com.example.carrotmarket

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding


class StuffInfoActivity : AppCompatActivity() {
    //view binding 적용하고
    lateinit var binding: ActivityStuffInfoBinding

    private val imgList = mutableListOf<String>()

    //pagerHandler, imgSwiper 선언
    private val imgSwiper = ImageSwiper()
    private val pageHandler = Handler(Looper.getMainLooper())
    private val autoScrollInterval = 1000L // 자동 스크롤 간격 (1초)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stuff_info)

        binding = ActivityStuffInfoBinding.inflate(layoutInflater)

        // Intent로 전달된 데이터 가져오기



        initDummyData()
        initViewPager()
        imgSwiper.start()

        setContentView(binding.root)

        //기능 추가
        //뒤로 가기 아이콘 선택하면 HomeFragment 페이지로 넘어가도록 설정
        binding.tvInfoPreviousArrow.setOnClickListener {
            finish()
        }

        //챌린지 미션 추가
//        val data =
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//                intent.getSerializableExtra("information", ProductInfo::class.java)
//            } else {
//                intent.getSerializableExtra("key") as ProductInfo
//            } ?: ProductInfo(R.drawable.icon_best_s, "null", "null", "null", "0", "0")
//
//
            val data =
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    intent.getSerializableExtra("key", ProductEntity::class.java)
                } else {
                    intent.getSerializableExtra("key") as ProductEntity
                } ?: ProductEntity(R.drawable.icon_best_s, "null", "null", "null", "0", "0")


//            binding.ivDetailImgVp.setImageResource(data.thumbnail)
        binding.tvLocation.text = data.location
        binding.tvItemInfoTitle.text = data.title
        binding.ivBottomBarPrice.text = data.price
    }


    override fun onDestroy() {
        super.onDestroy()
        imgSwiper.interrupt()
    }

    inner class ImageSwiper:Thread() {
        override fun run() {
            try {
                while (true) {
                    sleep(autoScrollInterval)
                    pageHandler.post{
                        //item번호 저장
                        var position = binding.ivDetailImgVp.currentItem

                        if (position == 2) {
                            position = 0
                        }
                        else{
                            position++
                        }
                        runOnUiThread{
                            binding.ivDetailImgVp.currentItem = position }

                    }
                }
            } //try문 종료
            catch(e : InterruptedException){
              Log.d("INTERRUPT", "쓰레드 종료")
interrupt()
            }//catch문 종료
        }//run()종료
    }

    private fun initViewPager() {
        //생성자 안 context와 imgList 넣어주기
        binding.ivDetailImgVp.adapter = ImageSliderVPAdapter(applicationContext, imgList)
        binding.ivDetailImgVp.orientation =
            ViewPager2.ORIENTATION_HORIZONTAL //가로 , 좌우로 swipe 방향 설정, 세로도 설정가능, default는 horizontal


    }

    //자동 스크롤 기능을 위해 Runnable 사용
    val autoScrollRunnable = object : Runnable {
        override fun run() {
            binding.ivDetailImgVp.currentItem =
                (binding.ivDetailImgVp.currentItem + 1) % imgList.size
            pageHandler.postDelayed(this, autoScrollInterval)
        }
    }

    private fun initDummyData() {

        imgList.add("https://cdn.pixabay.com/photo/2017/01/22/12/07/imac-1999636_1280.png")
        imgList.add("https://cdn.pixabay.com/photo/2015/01/08/18/25/desk-593327_1280.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2014/09/24/14/29/macbook-459196_1280.jpg")

    }




}
