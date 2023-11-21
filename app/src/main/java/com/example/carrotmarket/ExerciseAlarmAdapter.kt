package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemExerciseAlarmBinding
import kotlin.coroutines.coroutineContext

class ExerciseAlarmAdapter(val alarmList: ArrayList<DataExerciseAlarm>) :
    RecyclerView.Adapter<ExerciseAlarmAdapter.ViewHolder>() {

//    private lateinit var itemClickListener: OnItemClickListener
//    interface OnItemClickListener{
//        fun onItemClick(myWord: DataExerciseAlarm)
//    }

    //ViewHolder구현
    inner class ViewHolder(val binding: ItemExerciseAlarmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        //binding함수 선언, myWord로 받은 내용을 text에 넣어주겠다
        fun bind(exerciseAlarm: DataExerciseAlarm) {
            binding.tvItemAlarmContents1Main.text = exerciseAlarm.main_tv
            binding.tvItemAlarmContents1Sub.text = exerciseAlarm.sub_tv
            binding.tvItemAlarmContents1Time.text = exerciseAlarm.time
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemExerciseAlarmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = alarmList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(alarmList[position])
    }

}