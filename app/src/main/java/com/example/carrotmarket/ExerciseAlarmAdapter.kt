package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemExerciseAlarmBinding

class ExerciseAlarmAdapter(val alarmList: ArrayList<DataExerciseAlarm>) :
    RecyclerView.Adapter<ExerciseAlarmAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemExerciseAlarmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(exerciseAlarm: DataExerciseAlarm) {
            binding.itemEATvMain.text = exerciseAlarm.main_tv
            binding.itemEATvSub.text = exerciseAlarm.sub_tv
            binding.itemEATvTime.text = exerciseAlarm.time
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