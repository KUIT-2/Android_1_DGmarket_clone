package com.example.carrotmarket

import android.os.Build
import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toDrawable
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding
import com.example.carrotmarket.databinding.FragmentHomeBinding

class StuffInfoActivity : AppCompatActivity() {
    lateinit var binding:ActivityStuffInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityStuffInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivBackStu.setOnClickListener{
            finish()
        }

        // TODO: intent으로 전달 받은 데이터를 getStringExtra() 으로 받아오기
        //  챌린지 미션: Serializable로 받아온 Data class를 이용해보기
        // val data = ???
        val data=if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.TIRAMISU){
            intent.getSerializableExtra("information",ProductInfo::class.java)
        }else{
            intent.getSerializableExtra("key") as ProductInfo?
        }?: ProductInfo(0,"null","null","null",0,0)//엘비스 연산자 null이면 뒤에거넣을거 null대비
        binding.imTopStu.setImageResource(data.thumbnail)
        binding.tvLocation.text=data.location
        binding.tvTitle.text=data.title
        binding.tvPrice.text=data.price
    }
}