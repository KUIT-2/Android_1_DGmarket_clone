package com.example.carrotmarket

import android.os.Build
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.core.graphics.drawable.toDrawable
import androidx.viewpager2.widget.ViewPager2
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding
import com.example.carrotmarket.databinding.FragmentHomeBinding

class StuffInfoActivity : AppCompatActivity() {
    lateinit var binding:ActivityStuffInfoBinding
    private val imageSwiper=ImageSwiper()//swiper구현
    private val pagerHandler= Handler(Looper.getMainLooper())//뒤에가 메세지 큐, 핸들러 만듬
    private val imgList= mutableListOf<String>()///그냥 binding 하는 부분에서 넘겨주는것만 대체하기
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivBackStu.setOnClickListener{
            finish()//뒤로가기누르면 끝
        }

        //TODO:여기 아마 고쳐아 될 entity로 고침
        val data=if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("information",ProductEntity::class.java)//Entity 클래스에서 받아와야 하는데 왜 안되는가
        }else{
            intent.getSerializableExtra("key") as ProductEntity?
        }?: ProductEntity(0,"null","null","null",0,0)//엘비스 연산자 null이면 뒤에거넣을거 null대비

        //binding.imTopStu.setImageResource(data.thumbnail)//Glide형태로 넘겨야하니흠
        binding.tvLocation.text=data.location//위치
        binding.tvTitle.text=data.title//제목
        binding.tvPrice.text=data.price//가격

        imageSwiper.start()
        initDummyData()
        initViewPager()


    }

    override fun onDestroy() {
        super.onDestroy()
        imageSwiper.interrupt()
    }
    inner class ImageSwiper:Thread(){
        override fun run() {//스레드의 역할로 이거 실행한다 여기에 넣어서 실행
            try {
                while(true){
                    sleep(2000)
                    pagerHandler.post{//Post를 통해서 전달된 runnable객체는 핸들러를 통해 해당 스레드에서 실행된다!
                        var position=binding.imTopStu.currentItem//위치전달이요
                            position++;//실습과 다르게 여기는 postion을 내가 무한대로 설정해놨으니, 그냥 증가 시키면 자연스럽게 넘어가짐!
                        binding.imTopStu.currentItem=position
                    }//이벤트등록
                }
            }catch (e:InterruptedException){
                Log.d("interupt","스레드종료")
                interrupt()
            }//exctpion나면 종료
        }
    }

    //여기에 쓰레드 하나 생성해서 sleep 1000으로 해서 움직이게!

    private fun initViewPager() {
        binding.imTopStu.adapter=ImageSliderVPAdapter(applicationContext,imgList)//어댑터 적용+
        binding.imTopStu.orientation= ViewPager2.ORIENTATION_HORIZONTAL//orientation
    }
    private fun initDummyData() {//이미지 리소스&텍스트
        imgList.add("https://cdn.pixabay.com/photo/2016/12/13/05/15/puppy-1903313_640.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2016/01/05/17/51/maltese-1123016_640.jpg")
        imgList.add("https://cdn.pixabay.com/photo/2018/04/23/14/38/dog-3344414_640.jpg")
    }
}