package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemHomeProductBinding

class ProductAdapter(val productList: ArrayList<DataProduct>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var itemClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(myProduct: DataProduct)
    }

    inner class ViewHolder(val binding: ItemHomeProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(myProduct: DataProduct) {
            // 각각의 리사이클러뷰 아이템에 데이터 할당
            binding.itemImgThumnailPicture.setImageResource(myProduct.thumnail)
            binding.itemTvTitle.text = myProduct.title
            binding.itemTvAddress.text = myProduct.address
            binding.itemTvPrice.text = myProduct.price
            binding.itemTvComment.text = myProduct.commentNum.toString()
            binding.itemTvLike.text = myProduct.likeNum.toString()

            // 각각의 리사이클러뷰 아이템 클릭 시
            binding.itemConstraintLayout.setOnClickListener {
                itemClickListener.onItemClick(myProduct)
            }
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        itemClickListener = onItemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding =
            ItemHomeProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productList[position])
    }
}