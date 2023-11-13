package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemKeywordAlarmBinding

class KeywordAlarmAdpater(val alarmLst: ArrayList<DataKeywordAlarm>) :
    RecyclerView.Adapter<KeywordAlarmAdpater.ViewHolder>() {
    inner class ViewHolder(val binding: ItemKeywordAlarmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(keywordAlarm: DataKeywordAlarm) {
            binding.itemKATvMain.text = keywordAlarm.main_tv
            binding.itemKATvSub.text = keywordAlarm.sub_tv
            binding.itemKATvTime.text = keywordAlarm.time
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemKeywordAlarmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = alarmLst.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(alarmLst[position])
    }
}