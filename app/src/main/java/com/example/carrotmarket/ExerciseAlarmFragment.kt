package com.example.carrotmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.carrotmarket.databinding.FragmentExerciseAlarmBinding

class ExerciseAlarmFragment : Fragment() {

    private lateinit var binding: FragmentExerciseAlarmBinding
    private var alarmList: ArrayList<DataExerciseAlarm> = arrayListOf()
    private var alarmAdapter: ExerciseAlarmAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExerciseAlarmBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        initExerciseAlarm()
        initRecyclerView()
        return binding.root


    }

    private fun initRecyclerView() {
        alarmAdapter = ExerciseAlarmAdapter(alarmList)
        binding.recyclerView.adapter = alarmAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun initExerciseAlarm() {
        alarmList.addAll(
            arrayListOf(
                DataExerciseAlarm("11111111님, 아직 당근마켓 새 이름을 모르시나요?","새로워진 당신 근처의 '01'을 만나보세요","1주전"),
                DataExerciseAlarm("22222222님, 아직 당근마켓 새 이름을 모르시나요?","새로워진 당신 근처의 '02'을 만나보세요","2주전"),
                DataExerciseAlarm("33333333님, 아직 당근마켓 새 이름을 모르시나요?","새로워진 당신 근처의 '03'을 만나보세요","3주전"),
                DataExerciseAlarm("44444444님, 아직 당근마켓 새 이름을 모르시나요?","새로워진 당신 근처의 '04'을 만나보세요","4주전"),
                DataExerciseAlarm("55555555님, 아직 당근마켓 새 이름을 모르시나요?","새로워진 당신 근처의 '05'을 만나보세요","5주전"),
                DataExerciseAlarm("66666666님, 아직 당근마켓 새 이름을 모르시나요?","새로워진 당신 근처의 '06'을 만나보세요","6주전"),
                DataExerciseAlarm("77777777님, 아직 당근마켓 새 이름을 모르시나요?","새로워진 당신 근처의 '07'을 만나보세요","7주전"),
                DataExerciseAlarm("88888888님, 아직 당근마켓 새 이름을 모르시나요?","새로워진 당신 근처의 '08'을 만나보세요","8주전")
            )
        )
    }


}