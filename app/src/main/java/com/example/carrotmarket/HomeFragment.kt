package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentHomeBinding
class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

    var productAdapter: ProductAdapter? = null
    val productList: ArrayList<ProductInfo> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //기능추가
//        binding.item1Layout.setOnClickListener() {
//            val intent = Intent(requireContext(), StuffInfoActivity::class.java)
//            startActivity(intent)
//        }

        //알람 페이지로 넘어가기 구현
        binding.ivHomeAlarm.setOnClickListener {
            val intent = Intent(requireContext(), AlarmActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    } //View 닫기

    // Fragment 생명 주기
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDummyData()
        attachProductAdapter()
    }

    private fun attachProductAdapter() {
        productAdapter = ProductAdapter(productList)
        // TODO: 작성한 어댑터를 binding과 연결하고 layoutManager 등록하기
        binding.recyclerView.adapter = productAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false )


        // TODO : setOnItemClickListener에 제공할 인터페이스를 익명 클래스로 작성하고,  화면 클릭 이벤트 구현하기
        productAdapter!!.setOnItemClickListener( object : ProductAdapter.OnItemClickListener {
            override fun onItemClick(productInfo: ProductInfo ) {
                //클릭 이벤트 구현
                //새 인텐트 구현
                val intent = Intent(requireContext(), StuffInfoActivity::class.java)
                intent.putExtra("key", productInfo)
                startActivity(intent)

            }
        }

        )
    }

    // TODO: 각자 구성한 데이터 클래스에 맞게 더미 데이터를 구성해보기
    private fun initDummyData() {
        productList.addAll(
            arrayListOf(
                ProductInfo(R.drawable.icon_best_s, "상품1제목", "서울특별시 강서구·10분전", "19000원", "1", "1"),
                ProductInfo(R.drawable.icon_best_s, "상품2제목", "서울특별시 강서구·20분전", "29000원", "1", "1"),
                ProductInfo(R.drawable.icon_best_s, "상품3제목", "서울특별시 강서구·30분전", "39000원", "1", "1"),
                ProductInfo(R.drawable.icon_best_s, "상품4제목", "서울특별시 강서구·40분전", "19000원", "1", "1"),
                ProductInfo(R.drawable.icon_best_s, "상품6제목", "서울특별시 강서구·60분전", "119000원", "1", "1"),
                ProductInfo(R.drawable.icon_best_s, "상품6제목", "서울특별시 강서구·60분전", "119000원", "1", "1"),
            )
        )
    }

}