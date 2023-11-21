package com.example.carrotmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentKeywordAlarmBinding


class KeywordAlarmFragment : Fragment() {

    private lateinit var binding:FragmentKeywordAlarmBinding
    private var keywordList:ArrayList<DataKeywordAlarm> = arrayListOf()
    private var keywordAdapter: KeywordAlarmAdapter?= null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKeywordAlarmBinding.inflate(inflater, container, false)

        initKeywordAlarm()
        initRecyclerView()
        // Inflate the layout for this fragment
        return binding.root
    }

    private fun initRecyclerView(){
        keywordAdapter = KeywordAlarmAdapter(keywordList)
        binding.recyclerView.adapter = keywordAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun initKeywordAlarm(){
        keywordList.addAll(
            arrayListOf(
                DataKeywordAlarm("11111111님, OO에 대해서 들어보셨나요?", "새로워진 당신 근처의 '01'을 만나보세요", "1주전"),
                DataKeywordAlarm("22222222님, OO에 대해서 들어보셨나요?", "새로워진 당신 근처의 '02'을 만나보세요", "2주전"),
                DataKeywordAlarm("33333333님, OO에 대해서 들어보셨나요?", "새로워진 당신 근처의 '03'을 만나보세요", "3주전"),
                DataKeywordAlarm("44444444님, OO에 대해서 들어보셨나요?", "새로워진 당신 근처의 '04'을 만나보세요", "4주전"),
                DataKeywordAlarm("55555555님, OO에 대해서 들어보셨나요?", "새로워진 당신 근처의 '05'을 만나보세요", "5주전"),
                DataKeywordAlarm("66666666님, OO에 대해서 들어보셨나요?", "새로워진 당신 근처의 '06'을 만나보세요", "6주전"),
                DataKeywordAlarm("77777777님, OO에 대해서 들어보셨나요?", "새로워진 당신 근처의 '07'을 만나보세요", "7주전"),
                DataKeywordAlarm("88888888님, OO에 대해서 들어보셨나요?", "새로워진 당신 근처의 '08'을 만나보세요", "8주전"),


            )
        )
    }

}