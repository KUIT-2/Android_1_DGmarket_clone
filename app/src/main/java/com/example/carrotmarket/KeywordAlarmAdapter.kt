package com.example.carrotmarket

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.carrotmarket.databinding.ItemExerciseAlarmBinding
import com.example.carrotmarket.databinding.ItemKeywordAlarmBinding

class KeywordAlarmAdapter(val keywordList: ArrayList<DataKeywordAlarm>) :
    RecyclerView.Adapter<KeywordAlarmAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: ItemKeywordAlarmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(keywordAlarm: DataKeywordAlarm){
            binding.tvItemAlarmContents2Main.text = keywordAlarm.main_tv
            binding.tvItemAlarmContents2Sub.text = keywordAlarm.sub_tv
            binding.tvItemAlarmContents2Time.text = keywordAlarm.time
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder{
       val binding =
           ItemKeywordAlarmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = keywordList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(keywordList[position])
    }
}