package com.example.carrotmarket

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.carrotmarket.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        //만들어놓은 화면 클릭시 상세정보(stuff로 이동)
        binding.item1Layout.setOnClickListener{
            val intent= Intent(requireContext(),StuffInfoActivity::class.java)//reflection 알아오기
            //fragment this 아닌 requireContext 사용
            startActivity(intent)
        }

        //alarm누르면 그 화면 가지게
        binding.ivAlarm.setOnClickListener{
            val intent= Intent(requireContext(),AlarmActivity::class.java)//reflection 알아오기
            //fragment this 아닌 requireContext 사용
            startActivity(intent)
        }


        return binding.root
    }

}