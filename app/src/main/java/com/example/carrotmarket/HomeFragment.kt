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
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private var productList: ArrayList<ProductEntity> = arrayListOf()
    private var productAdapter: ProductAdapter? = null

    private var productDB: ProductDatabase? = null

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

        // DB의 객체를 가져와 ProductDatabase에 저장해줌
        productDB = ProductDatabase.getInstance(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // IO Thread에서 돌아가는 하나의 Coroutine에서 data를 추가하고, Main Thread의 Coroutine으로 넘어와 리사이클러뷰에 다시 그림
        CoroutineScope(Dispatchers.IO).launch {

            // DB에 데이터 추가하는 함수 호출
            initProducts()

            // DB에 있는 모든 값 가져오기
            val arrList = productDB!!.getMyProductDAO().getAllMyProduct()

            withContext(Dispatchers.Main) {
                (binding.homeFRecyclerView.adapter as ProductAdapter).setData(arrList)
            }
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        productAdapter = ProductAdapter(productList)
        binding.homeFRecyclerView.adapter = productAdapter
        binding.homeFRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        productAdapter!!.setOnItemClickListener(object : ProductAdapter.OnItemClickListener {
            override fun onItemClick(myProduct: ProductEntity) {
                val intent = Intent(requireContext(), StuffInfoActivity::class.java)
                intent.putExtra("Key", myProduct)
                startActivity(intent)
            }
        })
    }

    private fun initProducts() {
//        productList.addAll(
//            arrayListOf(
//                ProductEntity(R.drawable.img_picture01, "상품제목1", "서울특별시 광진구", "10,000원", 1, 1),
//                ProductEntity(R.drawable.img_picture02, "상품제목2", "서울특별시 서대문구", "20,000원", 2, 2),
//                ProductEntity(R.drawable.img_picture03, "상품제목3", "서울특별시 강남구", "30,000원", 3, 3),
//                ProductEntity(R.drawable.img_picture04, "상품제목4", "서울특별시 동작구", "40,000원", 4, 4),
//                ProductEntity(R.drawable.img_picture05, "상품제목5", "서울특별시 마포구", "50,000원", 5, 5),
//            )
//        )
        // 상품1
        productDB!!.getMyProductDAO().insertMyProduct(
            ProductEntity(
                thumnail = R.drawable.img_picture01,
                title = "상품제목입니다1",
                address = "서울특별시 광진구",
                price = "10,000원",
                commentNum = 1,
                likeNum = 1
            )
        )
        // 상품2
        productDB!!.getMyProductDAO().insertMyProduct(
            ProductEntity(
                thumnail = R.drawable.img_picture02,
                title = "상품제목입니다2",
                address = "서울특별시 서대문구",
                price = "20,000원",
                commentNum = 2,
                likeNum = 2
            )
        )
        // 상품3
        productDB!!.getMyProductDAO().insertMyProduct(
            ProductEntity(
                thumnail = R.drawable.img_picture03,
                title = "상품제목입니다3",
                address = "서울특별시 강남구",
                price = "30,000원",
                commentNum = 3,
                likeNum = 3
            )
        )
        // 상품4
        productDB!!.getMyProductDAO().insertMyProduct(
            ProductEntity(
                thumnail = R.drawable.img_picture04,
                title = "상품제목입니다4",
                address = "서울특별시 동작구",
                price = "40,000원",
                commentNum = 4,
                likeNum = 4
            )
        )
        // 상품5
        productDB!!.getMyProductDAO().insertMyProduct(
            ProductEntity(
                thumnail = R.drawable.img_picture05,
                title = "상품제목입니다5",
                address = "서울특별시 마포구",
                price = "50,000원",
                commentNum = 5,
                likeNum = 5
            )
        )
    }

}
