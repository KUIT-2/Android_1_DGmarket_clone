package com.example.carrotmarket

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carrotmarket.databinding.ActivityStuffInfoBinding
import com.example.carrotmarket.databinding.ItemStuffInfoImageBinding

class ImageSliderVPAdapter(val context: Context,val imgList:MutableList<String>) :RecyclerView.Adapter<ImageSliderVPAdapter.ViewHolder>() {
//context와 img리스트를
    inner class ViewHolder(val binding:ItemStuffInfoImageBinding):RecyclerView.ViewHolder(binding.root){//holder선언하고 바인딩 받음
    fun bind(imgurl:String){//Glide를 써서 url을 통해서 이미지 받아오기
        Glide.with(context)
            .load(imgurl)//url받는부분
            .into(binding.itemIv)//imageView로 받는고, 이걸 viewpager 영ㅇ역에 넣음
        //나머지 특성 추가공부
    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=ItemStuffInfoImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)//binding 화면을 넣음
    }
    override fun getItemCount(): Int= Int.MAX_VALUE//무한 좌우 스크롤
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imgList[position%imgList.size])//사이즈 만큼 나눠서!
    }
}