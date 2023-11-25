package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentHomeBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    var productDB:ProductDB?=null//없으면 null 로
    private val productList: ArrayList<ProductEntity> = arrayListOf()//7주차:수정
    private var productAdapter: ProductAdapter? = null

    lateinit var mainActivity: MainActivity// context얻어오기 위해
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //home에서 넘어가니 여기에 imglist랑 viewpager 구현?
        //만들어놓은 화면 클릭시 상세정보(stuff로 이동)
        /*       binding.item1Layout.setOnClickListener {//나중에 Recycler item 클릭하면 되게
                   val intent = Intent(requireContext(), StuffInfoActivity::class.java)//reflection 알아오기
                   //fragment this 아닌 requireContext 사용
                   startActivity(intent)
               }*/
        //alarm누르면 그 화면 가pr지게

        productDB = ProductDB.getInstance(requireContext()) // 변경된 부분
        //여기서 실습은 activity 라서 this지만 여기선 안된다 그래서 requireCOntext넣음

        binding.ivAlarm.setOnClickListener {
            val intent = Intent(requireContext(), AlarmActivity::class.java)//reflection 알아오기
            //fragment this 아닌 requireContext 사용
            startActivity(intent)
        }
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {//UI 만드는 곳이라 UI 관련 작업은 이 이후에 하는게 좋다
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            initDummyData()//코루틴안에 작성,더미데이터 종류
            var products=productDB!!.getMyProductDao().getProducts()//products로 product 가져옴
            //이제 productList에 넣어젔느데 왜?
            // 실습보고 다시
            withContext(Dispatchers.Main){
                (binding.recyclerviewHome.adapter as ProductAdapter).setData(products)//datasetting 선언 했으니 가져가야함 아마 엮어주는 역할?
                //요거부터 해주기
            }
        }
        attachProductAdapter()
    }


    private fun attachProductAdapter() {
        productAdapter = ProductAdapter(productList)
        binding.recyclerviewHome.adapter = productAdapter
        binding.recyclerviewHome.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)//recyclerview 어떻게 보여줄지?
        productAdapter!!.setOnItemClickListener(object : ProductAdapter.OnItemClickListener {//어댑터 연동

            override fun onItemClick(ProductEntity: ProductEntity) {
                //여기서 넘어가는거 구현
                val intent = Intent(requireContext(), StuffInfoActivity::class.java)//StuffInfoActivity 로 화면 전환+frag이니 require
                intent.putExtra("information", ProductEntity)//이걸 보내고 get 에서 가져오기
                startActivity(intent)
            }

        })
    }

    private fun initDummyData() {
        productDB!!.getMyProductDao().addProduct(ProductEntity(R.drawable.computer, "상품1제목", "서울특별시 강서구·10분전", "19000원", 1, 1))
        productDB!!.getMyProductDao().addProduct(ProductEntity(R.drawable.computer, "상품1제목", "서울특별시 강서구·10분전", "19000원", 1, 1))
        productDB!!.getMyProductDao().addProduct(ProductEntity(R.drawable.computer, "상품1제목", "서울특별시 강서구·10분전", "19000원", 1, 1))
        productDB!!.getMyProductDao().addProduct(ProductEntity(R.drawable.computer, "상품1제목", "서울특별시 강서구·10분전", "19000원", 1, 1))
        productDB!!.getMyProductDao().addProduct(ProductEntity(R.drawable.computer, "상품1제목", "서울특별시 강서구·10분전", "19000원", 1, 1))
        productDB!!.getMyProductDao().addProduct(ProductEntity(R.drawable.computer, "상품1제목", "서울특별시 강서구·10분전", "19000원", 1, 1))
        productDB!!.getMyProductDao().addProduct(ProductEntity(R.drawable.computer, "상품1제목", "서울특별시 강서구·10분전", "19000원", 1, 1))
        productDB!!.getMyProductDao().addProduct(ProductEntity(R.drawable.computer1, "상품2제목", "서울특별시 강서구·20분전", "29000원", 2, 2))
        /*ProductEntity(R.drawable.computer, "상품1제목", "서울특별시 강서구·10분전", "19000원", 1, 1),
        ProductEntity(R.drawable.computer1, "상품2제목", "서울특별시 강서구·20분전", "29000원", 2, 2),
        ProductEntity(R.drawable.computer2, "상품3제목", "서울특별시 강서구·30분전", "39000원", 2, 2),*/
    }

}