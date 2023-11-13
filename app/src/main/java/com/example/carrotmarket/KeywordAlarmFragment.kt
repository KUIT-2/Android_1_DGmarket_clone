package com.example.carrotmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentKeywordAlarmBinding

class KeywordAlarmFragment : Fragment() {
    private lateinit var binding: FragmentKeywordAlarmBinding
    private var alarmList: ArrayList<DataKeywordAlarm> = arrayListOf()
    private var alarmAdapter: KeywordAlarmAdpater? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKeywordAlarmBinding.inflate(inflater, container, false)

        initKeywordAlarms()
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        alarmAdapter = KeywordAlarmAdpater(alarmList)
        binding.KAFRecyclerView.adapter = alarmAdapter
        binding.KAFRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun initKeywordAlarms() {
        alarmList.addAll(
            arrayListOf(
                DataKeywordAlarm(
                    getString(R.string.keyword_main_text),
                    getString(R.string.keyword_sub_text),
                    "1주전"
                ),
                DataKeywordAlarm(
                    getString(R.string.keyword_main_text),
                    getString(R.string.keyword_sub_text),
                    "2주전"
                ),
                DataKeywordAlarm(
                    getString(R.string.keyword_main_text),
                    getString(R.string.keyword_sub_text),
                    "3주전"
                ),
                DataKeywordAlarm(
                    getString(R.string.keyword_main_text),
                    getString(R.string.keyword_sub_text),
                    "4주전"
                ),
                DataKeywordAlarm(
                    getString(R.string.keyword_main_text),
                    getString(R.string.keyword_sub_text),
                    "5주전"
                ),
                DataKeywordAlarm(
                    getString(R.string.keyword_main_text),
                    getString(R.string.keyword_sub_text),
                    "6주전"
                ),
            )
        )
    }
}