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
    private var alarmAdpater: ExerciseAlarmAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExerciseAlarmBinding.inflate(inflater, container, false)

        initExerciseAlarms()
        initRecyclerView()

        return binding.root
    }

    private fun initRecyclerView() {
        alarmAdpater = ExerciseAlarmAdapter(alarmList)
        binding.EAFRecyclerView.adapter = alarmAdpater
        binding.EAFRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun initExerciseAlarms() {
        alarmList.addAll(
            arrayListOf(
                DataExerciseAlarm(
                    getString(R.string.exercise_main_text),
                    getString(R.string.exercise_sub_text),
                    "1주전"
                ),
                DataExerciseAlarm(
                    getString(R.string.exercise_main_text),
                    getString(R.string.exercise_sub_text),
                    "2주전"
                ),
                DataExerciseAlarm(
                    getString(R.string.exercise_main_text),
                    getString(R.string.exercise_sub_text),
                    "3주전"
                ),
                DataExerciseAlarm(
                    getString(R.string.exercise_main_text),
                    getString(R.string.exercise_sub_text),
                    "4주전"
                ),
                DataExerciseAlarm(
                    getString(R.string.exercise_main_text),
                    getString(R.string.exercise_sub_text),
                    "5주전"
                ),
                DataExerciseAlarm(
                    getString(R.string.exercise_main_text),
                    getString(R.string.exercise_sub_text),
                    "6주전"
                ),
            )
        )
    }

}