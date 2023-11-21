package com.example.carrotmarket
import android.view.ViewGroup
import android.content.Context
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.carrotmarket.databinding.ItemStuffInfoImgBinding

class ImageSliderVPAdapter(val context: Context, val imgList: MutableList<String>):
    RecyclerView.Adapter<ImageSliderVPAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemStuffInfoImgBinding) : RecyclerView.ViewHolder(binding.root) {
        //glide통해서 받아오기
        fun bind(imgUrl: String){

            //.with 빼먹지 않기
            Glide.with(context)
                .load(imgUrl)
                .into(binding.itemStuffInfoImg)

            //추가적으로 .placeholder() 또는 .error()등을 추가할 수 있다.
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemStuffInfoImgBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = imgList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imgList[position])
    }


}