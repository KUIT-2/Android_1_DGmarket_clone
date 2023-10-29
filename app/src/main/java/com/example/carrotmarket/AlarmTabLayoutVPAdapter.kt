package com.example.carrotmarket

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class AlarmTabLayoutVPAdapter(activity: FragmentActivity): FragmentStateAdapter(activity)  {
    override fun getItemCount(): Int =2//슬라이드 2개
    override fun createFragment(position: Int): Fragment {
        return when(position){//0번부터시작
            0->ExerciseAlarmFragment()//이런식으로 해서 두개 다 frag
            else->KeywordAlarmFragment()//나머진 text
        }
    }

}