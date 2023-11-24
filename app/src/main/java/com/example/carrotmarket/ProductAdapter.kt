package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemHomeProductBinding
import com.google.android.material.imageview.ShapeableImageView

class ProductAdapter(var productList: ArrayList<ProductEntity>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(ProductEntity: ProductEntity)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener//외부의 활동을 받는?
    }//초기화

    /*  해설: RecyclerView에 들어갈 item을 구성하는 xml의 이름이 item_home_product.xml 이므로
      * 따라서 binding 은 ItemHomeProductBinding으로 작성된다.
    */
    inner class ViewHolder(val binding: ItemHomeProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //ViewHolder를 만들어 놓으면 될 듯!!
        fun bind(ProductEntity: ProductEntity) {

            //binding.ivItemHomeThumbnail.//image를 어케주지 ?
            //이전엔 holder의 setImageResource썻음
            //혹은 그냥 findViewbyId 에서 imageVie
            val img:ImageView=binding.ivItemHomeThumbnailIm//imageView 담는 상수 하나 선언
            img.setImageResource(ProductEntity.thumbnail)//setImageResource해와서 부름
            binding.tvItemHomeContentsTitle.text=ProductEntity.title
            binding.tvItemHomeContentsLocation.text=ProductEntity.location
            binding.tvItemHomeContentsPrice.text=ProductEntity.price
            binding.tvItemHomeComment.text=ProductEntity.comment_num.toString()
            binding.tvItemHomeLike.text=ProductEntity.like_num.toString()
            binding.itemLayout.setOnClickListener {
                itemClickListener.onItemClick(ProductEntity)//view누르면 메인 페이지로 가지게
            }
        }
    }
    fun setData(products: List<ProductEntity>) {
        productList= products as ArrayList<ProductEntity>
        notifyDataSetChanged()
        //TO DO:HomeFragment 에서 생성해서 data setting 해주는 역할
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemHomeProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )//부모의 context받음
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = productList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 해석: holder의 타입이 위에서 구현한 ViewHolder 클래스이므로, 해당 클래스의 bind 함수를 실행.
        // 이 때 매개변수로 productList라는 ArrayList의 position에 위치하는 항목을 넘겨준다.
        holder.bind(productList[position])
    }


}