package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private val productList: ArrayList<ProductInfo> = arrayListOf()
    private var productAdapter: ProductAdapter? = null
    lateinit var mainActivity: MainActivity// context얻어오기 위해
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //만들어놓은 화면 클릭시 상세정보(stuff로 이동)
        /*       binding.item1Layout.setOnClickListener {//나중에 Recycler item 클릭하면 되게
                   val intent = Intent(requireContext(), StuffInfoActivity::class.java)//reflection 알아오기
                   //fragment this 아닌 requireContext 사용
                   startActivity(intent)
               }*/
        //alarm누르면 그 화면 가지게
        binding.ivAlarm.setOnClickListener {
            val intent = Intent(requireContext(), AlarmActivity::class.java)//reflection 알아오기
            //fragment this 아닌 requireContext 사용
            startActivity(intent)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDummyData()
        attachProductAdapter()
    }

    private fun attachProductAdapter() {
        productAdapter = ProductAdapter(productList)
        binding.recyclerviewHome.adapter = productAdapter
        binding.recyclerviewHome.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        // TODO: 작성한 어댑터를 binding과 연결하고 layoutManager 등록하기
        // TODO : setOnItemClickListener에 제공할 인터페이스를 익명 클래스로 작성하고,  화면 클릭 이벤트 구현하기
        productAdapter!!.setOnItemClickListener(object : ProductAdapter.OnItemClickListener {
            override fun onItemClick(productInfo: ProductInfo) {
                //여기서 넘어가는거 구현
                val intent = Intent(requireContext(), StuffInfoActivity::class.java)
                intent.putExtra("information", productInfo)//이걸 보내고 get에서 가져오기
                startActivity(intent)
            }
        })
    }

    // TODO: 각자 구성한 데이터 클래스에 맞게 더미 데이터를 구성해보기
    private fun initDummyData() {
        productList.addAll(
            arrayListOf(
                ProductInfo(R.drawable.computer, "상품1제목", "서울특별시 강서구·10분전", "19000원", 1, 1),
                ProductInfo(R.drawable.computer1, "상품2제목", "서울특별시 강서구·20분전", "29000원", 2, 2),
                ProductInfo(R.drawable.computer2, "상품3제목", "서울특별시 강서구·30분전", "39000원", 2, 2),
                ProductInfo(R.drawable.computer3, "상품4제목", "서울특별시 강서구·40분전", "19000원", 2, 2),
                ProductInfo(R.drawable.computer, "상품5제목", "서울특별시 강서구·50분전", "99000원", 2, 2),
                ProductInfo(R.drawable.computer1, "상품6제목", "서울특별시 강서구·60분전", "119000원", 2, 2),
                ProductInfo(R.drawable.computer1, "상품6제목", "서울특별시 강서구·60분전", "119000원", 2, 2),
                )
        )
    }

}