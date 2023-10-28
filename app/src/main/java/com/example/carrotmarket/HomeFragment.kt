package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var productList: ArrayList<DataProduct> = arrayListOf()
    private var productAdapter: ProductAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        // 알람 버튼
        binding.homeFImgHomeAlarm.setOnClickListener {
            val intent = Intent(requireContext(), AlarmActivity::class.java)
            startActivity(intent)
        }

        initProducts()
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        productAdapter = ProductAdapter(productList)
        binding.homeFRecyclerView.adapter = productAdapter
        binding.homeFRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        productAdapter!!.setOnItemClickListener(object : ProductAdapter.OnItemClickListener {
            override fun onItemClick(myProduct: DataProduct) {
                val intent = Intent(context, StuffInfoActivity::class.java)
                intent.putExtra("Key", myProduct)
                startActivity(intent)
            }
        })
    }

    private fun initProducts() {
        productList.addAll(
            arrayListOf(
                DataProduct(R.drawable.img_picture01, "상품제목1", "서울특별시 광진구", "10,000원", 1, 1),
                DataProduct(R.drawable.img_picture02, "상품제목2", "서울특별시 서대문구", "20,000원", 2, 2),
                DataProduct(R.drawable.img_picture03, "상품제목3", "서울특별시 강남구", "30,000원", 3, 3),
                DataProduct(R.drawable.img_picture04, "상품제목4", "서울특별시 동작구", "40,000원", 4, 4),
                DataProduct(R.drawable.img_picture05, "상품제목5", "서울특별시 마포구", "50,000원", 5, 5),
            )
        )
    }

}
